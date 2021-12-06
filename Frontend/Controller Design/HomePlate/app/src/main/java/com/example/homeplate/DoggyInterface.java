package com.example.homeplate;

import static com.example.homeplate.api.ApiClientFacotry.GetUserApi;

import android.os.Handler;
import android.text.TextUtils;

import com.example.homeplate.api.SlimCallback;
import com.example.homeplate.model.User;
import com.example.homeplate.model.staticUser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Interface for
 * All NON-LOCAL
 * Application Functions
 * @author Corbin Graham
 */
public interface DoggyInterface {

    /**
     * Status
     * Type: ENUM
     * <br>Status Values:<br>
     * - Status SUCCESS
     * <br>
     * - Status FAILURE
     * @author Corbin Graham
     */
    public enum Status
    {
        SUCCESS,
        FAILURE
    }

    /**
     * User Type
     * <br>
     *     Type: ENUM
     * <br>Types of User:<br>
     *     - Dog Owner<br>
     *     - Moderator<br>
     *     - Admin<br>
     * @author Corbin Graham
     */
    public enum UserType
    {
        // Types of User
        OWNER(0, "Dog Owner"),
        MODERATOR(1, "Moderator"),
        ADMIN(2, "Admin");

        private final int index;
        private final String description;

        private static Map map = new HashMap<>();

        UserType(int index, String description) {
            this.index = index;
            this.description = description;
        }

        static {
            for(UserType userType : UserType.values()) {
                map.put(userType.index, userType);
            }
        }

        public static UserType valueOf(int key) { return (UserType) map.get(key); }

        public int getIndex() { return index; }

        public String getDescription() { return description; }
    }

    /**
     * Controller for Common Internal Functions
     * @author Corbin Graham
     */
    interface DoggyController
    {
        /**
         * Checks if there is a User Signed in
         * <br>
         * This is a FUNCTION used for FUNCTIONS
         * <br>
         *     Returns:
         *     <br>
         *     - TRUE if Signed in
         *     <br>
         *     - FALSE if NOT Signed in
         * @return IS_USER_SIGNED_IN
         */
        public static boolean isSignedIn()
        {
            if(staticUser.getUser() != null) return true;
            return false;
        }

        /**
         * Create a login request
         * and return results as
         * MessageReturn type.
         * @param username Username (Email)
         * @param password Password
         * @return Return Message (String Error Message, ENUM Status)
         */
        public static MessageReturn login(String username, String password){

            MessageReturn returnMessage = new MessageReturn();

        /*GetUserApi().getAllUser().enqueue(new SlimCallback<List<User>>(user->{ staticUser.setlist(user); }));
                new Handler().postDelayed(new Runnable() {
                    @Override public void run() { failed.setText(staticUser.allusers.get(0).getFirstName()); }},700);*/

            if(username.isEmpty() || password.isEmpty()) return new MessageReturn("Username or Password is Empty.", DoggyInterface.Status.FAILURE);
            User puser = new User();

            puser.setEmail(username);
            puser.setPassword(password);

            GetUserApi().getUserByEmail(username).enqueue(new SlimCallback<User>(user -> {

                if(TextUtils.equals(puser.getEmail(), user.getEmail()) && TextUtils.equals(puser.getPassword(), user.getPassword()))
                {
                    returnMessage.setMessage("Login Successful");

                    new Handler().postDelayed(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            //sets current user
                            staticUser.setUser(user);
                            //generates the list of all users besides current
                            GetUserApi().getEverbody(user.getEmail()).enqueue(new SlimCallback<List<User>>(user->{ staticUser.setlist(user); }));
                            returnMessage.setStatus(DoggyInterface.Status.SUCCESS);
                            returnMessage.setMessage("Login Successful");
                        }
                    },1000);
                }
                else
                {
                    puser.setEmail(user.getEmail());
                    returnMessage.setStatus(DoggyInterface.Status.FAILURE);
                    returnMessage.setMessage("Username/Password Doesn't Match.");
                }
            }));

            // TODO Change SUCCESS to FAILURE
            if(returnMessage.getStatus() == null) return new MessageReturn("Unable to Connect.", DoggyInterface.Status.SUCCESS);

            return returnMessage;
        }

        /**
         * Matching Function
         */
        public static void match()
        {
            // TODO Make changes if Necessary
            // This is the previously implemented function
            /**
             * @author Mark Gores
             */
            if(staticUser.getIndex() < staticUser.getUsers().size()) {
                GetUserApi().match(staticUser.getUser().getId(), staticUser.getUsers().get(staticUser.getIndex()).getId()).enqueue(new SlimCallback<User>(user -> {
                }));
                staticUser.incrementIndex();
            }
        }

        /**
         * Send a message to match
         */
        public static void sendMessage(int chatIndex, String message)
        {
            // Send ^MESSAGE to User(chatIndex)
            // Check if possible then send
            // If not possible, maybe return?
        }
    }

    /**
     * Offload Data Assertion and
     * Collection from Individual Views
     * @author Corbin Graham
     */
    interface DoggyView
    {
        /**
         * Get User's Name
         * @return Name
         */
        public static String getMyName() {
            if(staticUser.getUser() != null)
                return staticUser.getUser().getDog().getFirstNameDog();
            else return "No Name Available";
        }

        /**
         * Get User's Description
         * @return Name
         */
        public static String getMyDescription() {
            if(staticUser.getUser() != null)
                return staticUser.getUser().getDog().getDescriptionDog();
            else return "No Description Available";
        }

        /**
         * Get User's Profile Image
         * @todo Implement Image from User
         * @return Image
         */
        public static int getMyImage() {
            if(staticUser.getUser() != null)
                return R.drawable.icon_match_24;    // TODO
            else return R.drawable.icon_profile_24;
        }

        /**
         * Get Next User's Dog Name
         * @return Name
         */
        public static String getName() {
            if(staticUser.getUser() != null && staticUser.getIndex() < staticUser.getUsers().size())
                return staticUser.getUsers().get(staticUser.getIndex()).getDog().getFirstNameDog();
            else return "No Dog Available";
        }

        /**
         * Get Next User's Dog Description
         * @return Description
         */
        public static String getDescription() {
            if(staticUser.getUser() != null && staticUser.getIndex() < staticUser.getUsers().size())
                return staticUser.getUsers().get(staticUser.getIndex()).getDog().getDescriptionDog();
            else return "No Description Available";
        }

        /**
         * Get Next User's Profile Image
         * @todo Implement Image from UserS
         * @return Image
         */
        public static int getImage() {
            if(staticUser.getUser() != null && staticUser.getIndex() < staticUser.getUsers().size())
                return R.drawable.icon_match_24;    // TODO
            else return R.drawable.icon_profile_24;
        }

        /**
         * Get Name of User for Chat
         * @return Name
         */
        public static MessageReturn getChatName(int index) {
            if(index < staticUser.getUsers().size() && staticUser.getUsers().get(index) != null)
                return new MessageReturn(staticUser.getUsers().get(index).getFirstName(), Status.SUCCESS);
            else return new MessageReturn("No Name Available", Status.FAILURE);
        }

        /**
         * Get Chat Message
         * @// TODO: 12/3/21 Implement Method
         * @return Name
         */
        public static String getChat() {
            return "";
        }
    }


}
