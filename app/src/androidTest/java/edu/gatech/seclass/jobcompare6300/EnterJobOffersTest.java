package edu.gatech.seclass.jobcompare6300;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class EnterJobOffersTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @BeforeClass
    public static void beforeClass() {
        ApplicationProvider.getApplicationContext().deleteDatabase("joffer");
    }

    @Test
    public void enterMultipleJobOffersTest() {
        ViewInteraction materialButton = onView(
                allOf(withId(R.id.btnJobOffer), withText("Enter Job Offers"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        0),
                                1),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.editOfferTitle),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("Engineer"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.editOfferCompany),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        1),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("COP"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.editOfferLocation),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        2),
                                1),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText("Houston, TX"), closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.editOfferLivingCost),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        3),
                                1),
                        isDisplayed()));
        appCompatEditText4.perform(replaceText("5"), closeSoftKeyboard());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.editOfferYearlySalary),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        4),
                                1),
                        isDisplayed()));
        appCompatEditText5.perform(replaceText("100000"), closeSoftKeyboard());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.editOfferYearlyBonus),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        5),
                                1),
                        isDisplayed()));
        appCompatEditText6.perform(replaceText("20000"), closeSoftKeyboard());

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.editOfferRSU),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        6),
                                1),
                        isDisplayed()));
        appCompatEditText7.perform(replaceText("10000"), closeSoftKeyboard());

        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.editOfferRelocation),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        7),
                                1),
                        isDisplayed()));
        appCompatEditText8.perform(replaceText("10000"), closeSoftKeyboard());

        ViewInteraction appCompatEditText9 = onView(
                allOf(withId(R.id.editOfferHolidays),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        8),
                                1),
                        isDisplayed()));
        appCompatEditText9.perform(replaceText("5"), closeSoftKeyboard());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.btnOfferSave), withText("Save"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        2),
                                0),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction materialButton3 = onView(
                allOf(withId(R.id.btnNewOffer), withText("New Offer"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        3),
                                0),
                        isDisplayed()));
        materialButton3.perform(click());

        ViewInteraction appCompatEditText10 = onView(
                allOf(withId(R.id.editOfferTitle),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText10.perform(replaceText("ML"), closeSoftKeyboard());

        ViewInteraction appCompatEditText11 = onView(
                allOf(withId(R.id.editOfferCompany),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        1),
                                1),
                        isDisplayed()));
        appCompatEditText11.perform(replaceText("XOM"), closeSoftKeyboard());

        ViewInteraction appCompatEditText12 = onView(
                allOf(withId(R.id.editOfferLocation),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        2),
                                1),
                        isDisplayed()));
        appCompatEditText12.perform(replaceText("Houston, TX"), closeSoftKeyboard());

        ViewInteraction appCompatEditText13 = onView(
                allOf(withId(R.id.editOfferLivingCost),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        3),
                                1),
                        isDisplayed()));
        appCompatEditText13.perform(replaceText("5"), closeSoftKeyboard());

        ViewInteraction appCompatEditText14 = onView(
                allOf(withId(R.id.editOfferYearlySalary),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        4),
                                1),
                        isDisplayed()));
        appCompatEditText14.perform(replaceText("100000"), closeSoftKeyboard());

        ViewInteraction appCompatEditText15 = onView(
                allOf(withId(R.id.editOfferYearlyBonus),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        5),
                                1),
                        isDisplayed()));
        appCompatEditText15.perform(replaceText("20000"), closeSoftKeyboard());

        ViewInteraction appCompatEditText16 = onView(
                allOf(withId(R.id.editOfferRSU),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        6),
                                1),
                        isDisplayed()));
        appCompatEditText16.perform(replaceText("20000"), closeSoftKeyboard());

        ViewInteraction appCompatEditText17 = onView(
                allOf(withId(R.id.editOfferRelocation),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        7),
                                1),
                        isDisplayed()));
        appCompatEditText17.perform(replaceText("15000"), closeSoftKeyboard());

        ViewInteraction appCompatEditText18 = onView(
                allOf(withId(R.id.editOfferHolidays),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        8),
                                1),
                        isDisplayed()));
        appCompatEditText18.perform(replaceText("5"), closeSoftKeyboard());

        ViewInteraction materialButton5 = onView(
                allOf(withId(R.id.btnOfferSave), withText("Save"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        2),
                                0),
                        isDisplayed()));
        materialButton5.perform(click());

        ViewInteraction materialButton6 = onView(
                allOf(withId(R.id.btnOfferCancel), withText("Cancel"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        2),
                                1),
                        isDisplayed()));
        materialButton6.perform(click());

        ViewInteraction materialButton7 = onView(
                allOf(withId(R.id.btnCompareJobs), withText("Compare Job Offers"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        0),
                                3),
                        isDisplayed()));
        materialButton7.perform(click());

        ViewInteraction textView = onView(
                allOf(withText("ML"),
                        withParent(withParent(withId(R.id.compareJobsTableID))),
                        isDisplayed()));
        textView.check(matches(withText("ML")));
    }

    @Test
    public void cancelJobOffer() {
        ViewInteraction materialButton = onView(
                allOf(withId(R.id.btnJobOffer), withText("Enter Job Offers"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        0),
                                1),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.editOfferTitle),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("Hello"), closeSoftKeyboard());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.btnOfferCancel), withText("Cancel"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        2),
                                1),
                        isDisplayed()));
        materialButton2.perform(click());
    }

    @Test
    public void saveMissingInfoTest() {
        ViewInteraction materialButton = onView(
                allOf(withId(R.id.btnJobOffer), withText("Enter Job Offers"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        0),
                                1),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.btnOfferSave), withText("Save"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        2),
                                0),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction editText = onView(
                allOf(withId(R.id.editOfferTitle),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class))),
                        isDisplayed()));
        editText.check(matches(hasErrorText("Required Entry")));
    }

    @Test
    public void invalidJobEntryTest() {
        ViewInteraction materialButton = onView(
                allOf(withId(R.id.btnJobOffer), withText("Enter Job Offers"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        0),
                                1),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.editOfferRelocation),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        7),
                                1),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("50000"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.editOfferHolidays),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        8),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("50"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.editOfferYearlySalary),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        4),
                                1),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText("-100000"), closeSoftKeyboard());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.btnOfferSave), withText("Save"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        2),
                                0),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction editText = onView(
                allOf(withId(R.id.editOfferYearlySalary), withText("-100000"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class))),
                        isDisplayed()));
        editText.check(matches(hasErrorText("Entry must be a positive value")));

        ViewInteraction editText2 = onView(
                allOf(withId(R.id.editOfferRelocation), withText("50000"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class))),
                        isDisplayed()));
        editText2.check(matches(hasErrorText("Entry must be a value in [0, 25000]")));

        ViewInteraction editText3 = onView(
                allOf(withId(R.id.editOfferHolidays), withText("50"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.TableLayout.class))),
                        isDisplayed()));
        editText3.check(matches(hasErrorText("Entry must be an integer in [0, 20]")));

        ViewInteraction materialButton3 = onView(
                allOf(withId(R.id.btnOfferCancel), withText("Cancel"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        2),
                                1),
                        isDisplayed()));
        materialButton3.perform(click());
    }

    @Test
    public void returnHomeTest() {
        ViewInteraction materialButton = onView(
                allOf(withId(R.id.btnJobOffer), withText("Enter Job Offers"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        0),
                                1),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction appCompatTextView = onView(
                allOf(withId(R.id.tvTitle2), withText("Home Screen"),
                        childAtPosition(
                                childAtPosition(
                                        withId(androidx.appcompat.R.id.action_bar),
                                        0),
                                1),
                        isDisplayed()));
        appCompatTextView.perform(click());
    }

//    @Test
//    public void compareNoCurrentJobTest() {
//        ViewInteraction materialButton = onView(
//                allOf(withId(R.id.btnJobOffer), withText("Enter Job Offers"),
//                        childAtPosition(
//                                childAtPosition(
//                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
//                                        0),
//                                1),
//                        isDisplayed()));
//        materialButton.perform(click());
//
//        ViewInteraction appCompatEditText = onView(
//                allOf(withId(R.id.editOfferTitle),
//                        childAtPosition(
//                                childAtPosition(
//                                        withClassName(is("android.widget.TableLayout")),
//                                        0),
//                                1),
//                        isDisplayed()));
//        appCompatEditText.perform(replaceText("Engineer"), closeSoftKeyboard());
//
//        ViewInteraction appCompatEditText2 = onView(
//                allOf(withId(R.id.editOfferCompany),
//                        childAtPosition(
//                                childAtPosition(
//                                        withClassName(is("android.widget.TableLayout")),
//                                        1),
//                                1),
//                        isDisplayed()));
//        appCompatEditText2.perform(replaceText("COP"), closeSoftKeyboard());
//
//        ViewInteraction appCompatEditText3 = onView(
//                allOf(withId(R.id.editOfferLocation),
//                        childAtPosition(
//                                childAtPosition(
//                                        withClassName(is("android.widget.TableLayout")),
//                                        2),
//                                1),
//                        isDisplayed()));
//        appCompatEditText3.perform(replaceText("Houston, TX"), closeSoftKeyboard());
//
//        ViewInteraction appCompatEditText4 = onView(
//                allOf(withId(R.id.editOfferLivingCost),
//                        childAtPosition(
//                                childAtPosition(
//                                        withClassName(is("android.widget.TableLayout")),
//                                        3),
//                                1),
//                        isDisplayed()));
//        appCompatEditText4.perform(replaceText("5"), closeSoftKeyboard());
//
//        ViewInteraction appCompatEditText5 = onView(
//                allOf(withId(R.id.editOfferYearlySalary),
//                        childAtPosition(
//                                childAtPosition(
//                                        withClassName(is("android.widget.TableLayout")),
//                                        4),
//                                1),
//                        isDisplayed()));
//        appCompatEditText5.perform(replaceText("100000"), closeSoftKeyboard());
//
//        ViewInteraction appCompatEditText6 = onView(
//                allOf(withId(R.id.editOfferYearlyBonus),
//                        childAtPosition(
//                                childAtPosition(
//                                        withClassName(is("android.widget.TableLayout")),
//                                        5),
//                                1),
//                        isDisplayed()));
//        appCompatEditText6.perform(replaceText("20000"), closeSoftKeyboard());
//
//        ViewInteraction appCompatEditText7 = onView(
//                allOf(withId(R.id.editOfferRSU),
//                        childAtPosition(
//                                childAtPosition(
//                                        withClassName(is("android.widget.TableLayout")),
//                                        6),
//                                1),
//                        isDisplayed()));
//        appCompatEditText7.perform(replaceText("20000"), closeSoftKeyboard());
//
//        ViewInteraction appCompatEditText8 = onView(
//                allOf(withId(R.id.editOfferRelocation),
//                        childAtPosition(
//                                childAtPosition(
//                                        withClassName(is("android.widget.TableLayout")),
//                                        7),
//                                1),
//                        isDisplayed()));
//        appCompatEditText8.perform(replaceText("20000"), closeSoftKeyboard());
//
//        ViewInteraction appCompatEditText9 = onView(
//                allOf(withId(R.id.editOfferHolidays),
//                        childAtPosition(
//                                childAtPosition(
//                                        withClassName(is("android.widget.TableLayout")),
//                                        8),
//                                1),
//                        isDisplayed()));
//        appCompatEditText9.perform(replaceText("5"), closeSoftKeyboard());
//
//        ViewInteraction materialButton2 = onView(
//                allOf(withId(R.id.btnOfferSave), withText("Save"),
//                        childAtPosition(
//                                childAtPosition(
//                                        withClassName(is("android.widget.LinearLayout")),
//                                        2),
//                                0),
//                        isDisplayed()));
//        materialButton2.perform(click());
//
//        ViewInteraction materialButton3 = onView(
//                allOf(withId(R.id.btnOfferSave), withText("Compare"),
//                        childAtPosition(
//                                childAtPosition(
//                                        withClassName(is("android.widget.LinearLayout")),
//                                        2),
//                                0),
//                        isDisplayed()));
//        materialButton2.perform(click());
//
//        ViewInteraction editText = onView(
//                withText("Current job is not available!").check(matches(isDisplayed()));

//          onView(withText(R.string.toast)).inRoot(withDecorView(not(mActivityScenarioRule.getActivity().getWindow().getDecorView()))).check(matches(isDisplayed()));

//        ViewInteraction viewGroup = onView(
//                allOf(withParent(allOf(withId(android.R.id.content),
//                                withParent(withId(androidx.appcompat.R.id.decor_content_parent)))),
//                        isDisplayed()));
//        viewGroup.check(matches(isDisplayed()));
//
//    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
