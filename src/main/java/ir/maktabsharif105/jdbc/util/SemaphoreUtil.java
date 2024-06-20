package ir.maktabsharif105.jdbc.util;

import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class SemaphoreUtil {

    private static final Semaphore CREATE_ADVERT = new Semaphore(1);

    private static final Map<Long, Semaphore> CUSTOMERS_SEMAPHORE = new HashMap<>();

    @SneakyThrows
    public static void acquireCreateAdvert() {
        CREATE_ADVERT.acquire();
    }

    @SneakyThrows
    public static void releaseCreateAdvert() {
        CREATE_ADVERT.release();
    }

    @SneakyThrows
    public static void acquireCustomerSemaphore(Long customerId) {
        Semaphore semaphore;
        if (CUSTOMERS_SEMAPHORE.containsKey(customerId)) {
            semaphore = CUSTOMERS_SEMAPHORE.get(customerId);
        } else {
            semaphore = new Semaphore(1);
            CUSTOMERS_SEMAPHORE.put(customerId, semaphore);
        }
        semaphore.acquire();
    }

    @SneakyThrows
    public static void releaseCustomerSemaphore(Long customerId) {
        if (CUSTOMERS_SEMAPHORE.containsKey(customerId)) {
            Semaphore semaphore = CUSTOMERS_SEMAPHORE.get(customerId);
            boolean remove = true;
            if (semaphore.hasQueuedThreads()) {
                remove = false;
            }
            semaphore.release();
            if (remove) {
                CUSTOMERS_SEMAPHORE.remove(customerId);
            }

        }
    }

}
