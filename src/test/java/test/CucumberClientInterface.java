package test;

interface CucumberClientInterface {
    public void startServer();
    public void stopServer();
    public String getPasswordAdvice(String password);
    public String getPasswordStrength(String password);
}