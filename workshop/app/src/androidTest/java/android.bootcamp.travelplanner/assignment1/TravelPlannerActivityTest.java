package android.bootcamp.travelplanner.assignment1;


import android.app.Activity;
import android.app.Instrumentation;
import android.bootcamp.travelplanner.R;
import android.bootcamp.travelplanner.TravelPlannerActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.bootcamp.travelplanner.assignment1.ImageViewHasDrawableMatcher.hasDrawable;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.Intents.intending;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.EasyMock2Matchers.equalTo;


@RunWith(AndroidJUnit4.class)
public class TravelPlannerActivityTest {

    @Rule
    public IntentsTestRule<TravelPlannerActivity> activityTestRule =
            new IntentsTestRule<>(TravelPlannerActivity.class);

    @Test
    public void calculateTimeTakenByDividingDistanceByVelocity() {
        onView(withId(android.bootcamp.travelplanner.R.id.distance)).perform(typeText("333"));
        onView(withId(android.bootcamp.travelplanner.R.id.velocity)).perform(typeText("10"));

        onView(withId(android.bootcamp.travelplanner.R.id.calculate)).perform(click());
        onView(withId(android.bootcamp.travelplanner.R.id.time)).check(matches(withText(("33"))));
    }

    @Test
    public void calculateTimeTakenByDividingDistanceByVelocityWithBuffer() {
        onView(withId(android.bootcamp.travelplanner.R.id.distance)).perform(typeText("333"));
        onView(withId(android.bootcamp.travelplanner.R.id.velocity)).perform(typeText("10"));
        onView(withId(android.bootcamp.travelplanner.R.id.calculate)).perform(click());
        onView(withId(android.bootcamp.travelplanner.R.id.buffer)).perform(typeText("20"));

        onView(withId(android.bootcamp.travelplanner.R.id.calculateTotalTime)).perform(click());
        onView(withId(android.bootcamp.travelplanner.R.id.totalTime)).check(matches(withText(("53"))));
    }

    @Test
    public void shouldOpenCameraOnClick() {
        // Create a bitmap we can use for our simulated camera image
        Bitmap icon = BitmapFactory.decodeResource(
                InstrumentationRegistry.getTargetContext().getResources(),
                R.mipmap.ic_launcher);

        // Build a result to return from the Camera app
        Intent resultData = new Intent();
        resultData.putExtra("data", icon);
        Instrumentation.ActivityResult result = new Instrumentation.ActivityResult(Activity.RESULT_OK, resultData);

        intending(hasAction(android.provider.MediaStore.ACTION_IMAGE_CAPTURE)).respondWith(result);

        onView(withId(R.id.capture)).perform(click());
        intended(hasAction(android.provider.MediaStore.ACTION_IMAGE_CAPTURE));
        onView(withId(R.id.captured_photo)).check(matches(hasDrawable(icon)));

    }
}