package homies.goats.projet_jee;

/*
public class ProjetLoginModule implements LoginModule {
    private CallbackHandler callbackHandler;
    private boolean loginSuccess = false;

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState, Map<String, ?> options) {
        this.callbackHandler = callbackHandler;
    }

    @Override
    public boolean login() throws LoginException {
        NameCallback nameCallback = new NameCallback("email:");
        PasswordCallback passwordCallback = new PasswordCallback("password:", false);

        try {
            callbackHandler.handle(new javax.security.auth.callback.Callback[]{nameCallback, passwordCallback});

            String email = nameCallback.getName();
            char[] password = passwordCallback.getPassword();

            if (validateCredentials(email, new String(password))) {
                loginSuccess = true;
                return true;
            } else {
                throw new LoginException("Authentication failed");
            }

        } catch (UnsupportedCallbackException | java.io.IOException e) {
            throw new LoginException(e.getMessage());
        }
    }

    private boolean validateCredentials(String email, String password) {
        UserEntity user = getUserByEmail(email);
        if (user != null) {
            String storedPasswordHash = user.getPasswordHash();
            // Assuming the salt is available in the UserEntity
            String salt = user.getSalt();

            // Hash the provided password with salt and compare with stored hash
            try {
                String hashedPassword = generateHash(password, salt);
                return hashedPassword.equals(storedPasswordHash);
            } catch (NoSuchAlgorithmException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    private String generateHash(String password, String salt) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        String saltedPassword = password + salt;
        byte[] hashedBytes = md.digest(saltedPassword.getBytes());
        return ""; //DatatypeConverter.printHexBinary(hashedBytes).toLowerCase();
    }

    @Override
    public boolean commit() throws LoginException {
        return loginSuccess;
    }

    @Override
    public boolean abort() throws LoginException {
        return false;
    }

    @Override
    public boolean logout() throws LoginException {
        return false;
    }
}
*/
