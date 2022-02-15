package com.pasala.ssm.parameterstore;


import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagement;
import com.amazonaws.services.simplesystemsmanagement.model.GetParameterRequest;
import com.amazonaws.services.simplesystemsmanagement.model.GetParameterResult;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class SecretsHelperTest {

    @Test
    public void getParam() {
        AWSSimpleSystemsManagement ssmClient = Mockito.mock(AWSSimpleSystemsManagement.class);
        GetParameterResult getParameterResult = new GetParameterResult();
       /* Mockito.when(ssmClient.getParameter(Mockito.any(GetParameterRequest.class))).
                thenReturn(getParameterResult);
        SecretsHelper secretsHelper = new SecretsHelper();
        String value = secretsHelper.getParam("key");
        Assert.assertEquals("key", value);*/
    }
}