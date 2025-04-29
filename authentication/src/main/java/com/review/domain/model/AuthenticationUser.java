package com.review.domain.model;


import com.review.domain.Password;
import com.review.domain.UserId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthenticationUser {

    private UserId id;

    private Password password;

    public boolean isPasswordValid(Password password, Password.Matcher matcher) {
        return this.password.isPasswordValid(password, matcher);
    }

    public void setEncodedPassword(Password password, Password.Encoder encoder) {
        this.password = Password.encode(password, encoder);
    }

}
