package com.tenpo.profit.infraestructure.adapters.output.rest.percentage;

import com.tenpo.profit.infraestructure.adapters.output.rest.percentage.data.PercentageDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class PercentageRestAdapterTest {

    @Autowired
    private PercentageRestAdapter percentageRestAdapter;

    @Test
    public void getPercentageRetryOK() throws Exception {
        PercentageDTO percentage = this.percentageRestAdapter.getPercentage();
        verify(percentageRestAdapter, times(3)).getPercentage();
        assertThat(percentage.getPercentage()).isEqualTo(10);
    }

}