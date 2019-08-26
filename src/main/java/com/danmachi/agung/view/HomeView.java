package com.danmachi.indra.view;

import com.danmachi.indra.data.model.User;



public interface HomeView {
    void showUser(User user);
    void onSignOut();
}
