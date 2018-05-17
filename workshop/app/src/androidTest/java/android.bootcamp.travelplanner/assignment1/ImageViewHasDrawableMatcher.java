package android.bootcamp.travelplanner.assignment1;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.view.View;
import android.widget.ImageView;

import org.hamcrest.Description;

/**
 * A Matcher for Espresso that checks if an ImageView has a drawable applied to it.
 */
public class ImageViewHasDrawableMatcher {

    public static BoundedMatcher<View, ImageView> hasDrawable(final Bitmap img) {
        return new BoundedMatcher<View, ImageView>(ImageView.class) {
            @Override
            public void describeTo(Description description) {
                description.appendText("has drawable");
            }

            @Override
            public boolean matchesSafely(ImageView imageView) {
                return ((BitmapDrawable)imageView.getDrawable()).getBitmap().sameAs(img);
            }

        };
    }
}