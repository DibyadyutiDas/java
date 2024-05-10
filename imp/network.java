import android.app.usage.NetworkStats;
import android.app.usage.NetworkStatsManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.RemoteException;
import android.telephony.TelephonyManager;

public class DataUsageHelper {

    public static long getMobileDataUsageToday(Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            // NetworkStatsManager requires API level 23 or above
            return -1;
        }

        NetworkStatsManager networkStatsManager = (NetworkStatsManager) context.getSystemService(Context.NETWORK_STATS_SERVICE);
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);

        String subscriberId = telephonyManager.getSubscriberId();

        long startTime = getStartOfDay();
        long endTime = System.currentTimeMillis();

        long totalData = 0;

        try {
            NetworkStats networkStats = networkStatsManager.querySummary(
                    ConnectivityManager.TYPE_MOBILE,
                    subscriberId,
                    startTime,
                    endTime
            );

            NetworkStats.Bucket bucket = new NetworkStats.Bucket();

            while (networkStats.hasNextBucket()) {
                networkStats.getNextBucket(bucket);
                totalData += bucket.getRxBytes() + bucket.getTxBytes();
            }

            networkStats.close();

        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return totalData; // Returns total data in bytes
    }

    private static long getStartOfDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }
    
}