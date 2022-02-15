package com.pasala.ssm.parameterstore;

import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagement;
import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagementClientBuilder;
import com.amazonaws.services.simplesystemsmanagement.model.GetParameterRequest;
import com.amazonaws.services.simplesystemsmanagement.model.GetParameterResult;
import com.amazonaws.services.simplesystemsmanagement.model.PutParameterRequest;


public class SecretsHelper {
    private final AWSSimpleSystemsManagement ssmClient;
    private static AWSSecretsManager awsSecretsManager;

    public SecretsHelper() {
        this.ssmClient = AWSSimpleSystemsManagementClientBuilder.defaultClient();
        awsSecretsManager = AWSSecretsManagerClientBuilder.standard().build();
    }

    public String getParam(String paraKey) {
        GetParameterRequest request = new GetParameterRequest();
        request.withWithDecryption(true).setName(paraKey);
        GetParameterResult getParameterResult = ssmClient.getParameter(request);
        return getParameterResult.getParameter().getValue();
    }

    public void putParamValue(String name, String value) {
        PutParameterRequest putRequest = new PutParameterRequest();
        putRequest.setName(name);
        putRequest.setValue(value);
        putRequest.setOverwrite(true);
        ssmClient.putParameter(putRequest);

    }

    public static String getSecretValue(String secretName) {
        GetSecretValueRequest getSecretValueRequest =
                new GetSecretValueRequest().withSecretId(secretName);
        return awsSecretsManager.getSecretValue(getSecretValueRequest).getSecretString();

    }
}
