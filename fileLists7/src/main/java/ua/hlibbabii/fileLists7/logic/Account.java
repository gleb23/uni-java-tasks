/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.hlibbabii.fileLists7.logic;

import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Hlib Babii <hlib.babii at hlibbabii.ua>
 */
public class Account {
    private String username;
    private String password;
    
    public Account(String username, String password) {
        this.username = username;
        this.password = DigestUtils.md5Hex(password);
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
}
