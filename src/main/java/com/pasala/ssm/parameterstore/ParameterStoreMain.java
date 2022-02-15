package com.pasala.ssm.parameterstore;

public class ParameterStoreMain {
    public static void main(String[] args) {

        SecretsHelper secretsHelper = new SecretsHelper();

        String paraName = args[0];
        String paraKey = args[1];

        //Get password from parameter Store
        String parameterValue = secretsHelper.getParam(paraKey);
        System.out.println("The parameter value is"+ parameterValue);

        //Update the value in AWS Parameter Store
        secretsHelper.putParamValue("/test-app/dev/db-password", "Mahika");

        String secretName = SecretsHelper.getSecretValue("test-app/uat/secret");
        System.out.println("The secret name is" + secretName);

    }
}