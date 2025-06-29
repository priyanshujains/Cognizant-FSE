package org.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {
        // 1. Create mock
        ExternalApi mockApi = mock(ExternalApi.class);

        // 2. Create service and call method
        MyService service = new MyService(mockApi);
        service.fetchData(); // this should call mockApi.getData()

        // 3. Verify that getData() was called on the mock
        verify(mockApi).getData();
    }
}

