/**
 *
 */

package it.unibo.collections.social.impl;

import it.unibo.collections.social.api.SocialNetworkUser;
import it.unibo.collections.social.api.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


/**
 * This will be an implementation of
 * {@link SocialNetworkUser}:
 * 1) complete the definition of the methods by following the suggestions
 * included in the comments below.
 *
 * @param <U>
 *            Specific {@link User} type
 */
public final class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {

    /*
     *
     * [FIELDS]
     *
     * Define any necessary field
     *
     * In order to save the people followed by a user organized in groups, adopt
     * a generic-type Map:
     *
     * think of what type of keys and values would best suit the requirements
     */
    private HashMap<U,String> followed = new HashMap<>();


    /*
     * [CONSTRUCTORS]
     *
     * 1) Complete the definition of the constructor below, for building a user
     * participating in a social network, with 4 parameters, initializing:
     *
     * - firstName
     * - lastName
     * - username
     * - age and every other necessary field
     */
    /**
     * Builds a user participating in a social network.
     *
     * @param name
     *            the user firstname
     * @param surname
     *            the user lastname
     * @param userAge
     *            user's age
     * @param user
     *            alias of the user, i.e. the way a user is identified on an
     *            application
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge) {
        super(name, surname, user, userAge);
    }

    /*
     * 2) Define a further constructor where the age defaults to -1
     */

    public SocialNetworkUserImpl(final String name, final String surname, final String user) {
        super(name, surname, user, -1);
    }

    /*
     * [METHODS]
     *
     * Implements the methods below
     */
      /**
     * Adds a friend to the list of this user's current friends.
     *
     * @param group
     *            the group (circle) on which the user in going to be added
     * @param user
     *            the user to be added as a user followed
     * @return true if the user to be added as a followed person does not exist
     *         yet, false otherwise
     */
    @Override
    public boolean addFollowedUser(final String circle, final U user) {
        if (followed.containsKey(user)) {
            return false;
        }
            followed.put(user, circle);
        return true;
    }

    /**
     *
     * [NOTE] If no group with groupName exists yet, this implementation must
     * return an empty Collection.
     */
     /**
     * Gets the list of every person followed by this user disregarding the
     * group.
     *
     * @return the list of people followed by this user among all her groups
     */
    @Override
    public Collection<U> getFollowedUsersInGroup(final String groupName) {
        HashSet<U> followedGroup = new HashSet<>();
        for(U userIndex: followed.keySet()) {
            if(followed.get(userIndex).equals(groupName)) {
                followedGroup.add(userIndex);
            }
        }
        return followedGroup;
    }

    @Override
    public List<U> getFollowedUsers() {
        ArrayList<U> followedUsers = new ArrayList<>(followed.keySet());
        return followedUsers;
    }
}
