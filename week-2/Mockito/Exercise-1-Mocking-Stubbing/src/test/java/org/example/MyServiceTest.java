package org.example;


import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MyServiceTest {

    @Test
    public void testExternalApi() {
        // 1. Create mock of ExternalApi
        ExternalApi mockApi = mock(ExternalApi.class);

        // 2. Stub method to return mock data
        when(mockApi.getData()).thenReturn("Mock Data");

        // 3. Inject mock into service
        MyService service = new MyService(mockApi);

        // 4. Call method and assert result
        String result = service.fetchData();
        assertEquals("Mock Data", result);
    }
}
