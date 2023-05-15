package com.tenpo.profit.infraestructure.adapters.input.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tenpo.profit.application.ports.input.CalculateProfitUseCase;
import com.tenpo.profit.application.ports.input.GetProfitsUseCase;
import com.tenpo.profit.domain.model.Profit;
import com.tenpo.profit.errors.ErrorHandler;
import com.tenpo.profit.errors.exceptions.PercentageNotFoundException;
import com.tenpo.profit.infraestructure.adapters.input.rest.data.request.ProfitCalculateRequest;
import com.tenpo.profit.infraestructure.adapters.input.rest.data.response.ProfitQueryResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ProfitRestAdapterTest {

    private MockMvc mvc;

    @Mock
    private GetProfitsUseCase getProfitsUseCase;

    @Mock
    private CalculateProfitUseCase calculateProfitUseCase;

    @InjectMocks
    private ProfitRestAdapter profitRestAdapter;

    private JacksonTester<ProfitCalculateRequest> jsonProfitRequest;

    private JacksonTester<ProfitQueryResponse> jsonProfitCreateResponse;

    private JacksonTester<Iterable<ProfitQueryResponse>> jsonProfitQueryResponse;


    @BeforeEach
    void setUp() {

        JacksonTester.initFields(this, new ObjectMapper());

        mvc = MockMvcBuilders.standaloneSetup(profitRestAdapter)
                .setControllerAdvice(new ErrorHandler())
                .build();
    }


    @Test
    public void retrieveResponseProfitsOK() throws Exception {
        // given
        var useCaseResponse = new ArrayList<Profit>();
        useCaseResponse.add(new Profit("123", 2, 2, 10));

        var expectedResponse = new ArrayList<ProfitQueryResponse>();
        expectedResponse.add(new ProfitQueryResponse("123", 2, 2, 4.4f));

        given(getProfitsUseCase.getProfits()).willReturn(useCaseResponse);

        // when
        MockHttpServletResponse response =
                mvc.perform(MockMvcRequestBuilders.get("/v1/profit")
                    .accept(MediaType.APPLICATION_JSON))
                    .andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(
                jsonProfitQueryResponse.write(expectedResponse).getJson()
        );
    }

    @Test
    public void retrieveEmptyResponseProfits() throws Exception {
        // given
        var useCaseResponse = new ArrayList<Profit>();

        given(getProfitsUseCase.getProfits()).willReturn(useCaseResponse);

        // when
        MockHttpServletResponse response =
                mvc.perform(MockMvcRequestBuilders.get("/v1/profit")
                    .accept(MediaType.APPLICATION_JSON))
                    .andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("[]");
    }


    @Test
    void calculateProfitOK() throws Exception {
        // given
        var expectedResponse = new ProfitQueryResponse("123",2, 2, 4.4f);

        given(calculateProfitUseCase.calculateProfit(2,2)).willReturn(new Profit("123", 2, 2, 10));

        // when
        MockHttpServletResponse response =
                mvc.perform(MockMvcRequestBuilders.post("/v1/profit")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(jsonProfitRequest.write(new ProfitCalculateRequest(2, 2)).getJson()
                )).andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(response.getContentAsString()).isEqualTo(
                jsonProfitCreateResponse.write(expectedResponse).getJson()
        );
    }

    @Test
    void calculateProfitBadRequest() throws Exception {
        // when
        MockHttpServletResponse response =
                mvc.perform(MockMvcRequestBuilders.post("/v1/profit")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonProfitRequest.write(new ProfitCalculateRequest(0, 0)).getJson()
                        )).andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void calculateProfitPercentageNotFound() throws Exception {
        // given
        given(calculateProfitUseCase.calculateProfit(2,2)).willThrow(new PercentageNotFoundException());

        // when
        MockHttpServletResponse response =
                mvc.perform(MockMvcRequestBuilders.post("/v1/profit")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonProfitRequest.write(new ProfitCalculateRequest(2, 2)).getJson()
                        )).andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
    }
}