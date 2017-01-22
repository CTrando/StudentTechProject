package source;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import static java.util.concurrent.TimeUnit.*;

public class Timer {

	private final static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

	public void tick(Controller controller) {
		final Runnable myRunner = new Runnable() {
			public void run() {
				controller.update();
			}
		};
		final ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(myRunner, 0, 15, MILLISECONDS);
	}

}
