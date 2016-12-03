package com.example.matthew.trekaid;

import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityEspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void createAutomatedItemsTest(){
        for(int i = 0; i < 3; i++) {
            //Go to createNewItemActivity
            onView(withId(R.id.createNewItemButton)).perform(click());

            //Fill in new Item info
            onView(withId(R.id.itemNamePromptEditText)).perform(typeText("Automated Item #" + i), closeSoftKeyboard());
            onView(withId(R.id.defaultImagesImageButton)).perform(click());

            //Default dialog select image
            onView(withId(R.id.radioButton)).perform(click());
            onView(withId(R.id.defaultDialogSelectButton)).perform(click());

            //Create new item
            onView(withId(R.id.createItemButton)).perform(click());
        }

        //Check that creation the application returns to the main menu
        onView(withId(R.id.mainMenuTextView)).check(matches(withText("Main Menu")));
    }
}
