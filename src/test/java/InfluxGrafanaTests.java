import com.sun.management.OperatingSystemMXBean;
import org.influxdb.dto.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.management.ManagementFactory;
import java.util.concurrent.TimeUnit;

public class InfluxGrafanaTests {
    @Test
    public void grafTest() throws Exception {
        while (true) {
            OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(
                    OperatingSystemMXBean.class);
            System.out.println(osBean.getProcessCpuLoad());
            Point point = Point.measurement("cpumethod").time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                    .addField("cpu", (osBean.getProcessCpuLoad())).build();
            UpdateResults.post(point);
            Thread.sleep(500);
        }
    }

    @Test(description = "Login")
    public void launchApp() throws Exception {
        Thread.sleep(1000);
        Assert.fail();
    }

    @Test(description = "Search")
    public void sort() throws Exception {
        Thread.sleep(10000);
        Assert.fail();
    }

    @Test(description = "Select")
    public void selectAProduct() throws Exception {
        Thread.sleep(10000);

    }

    @Test(description = "Log Out")
    public void goToAboutPage() throws Exception {
        Thread.sleep(10000);

    }
}
