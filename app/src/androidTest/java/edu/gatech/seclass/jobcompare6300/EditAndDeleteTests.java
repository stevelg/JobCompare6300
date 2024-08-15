package edu.gatech.seclass.jobcompare6300;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
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
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class EditAndDeleteTests {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @BeforeClass
    public static void beforeClass() {
        ApplicationProvider.getApplicationContext().deleteDatabase("joffer");
    }

    @Test
    public void editJobTest() {
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

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.editOfferCompany),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        1),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("wefg"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.editOfferLocation),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        2),
                                1),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText("sdf,tx"), closeSoftKeyboard());

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
        appCompatEditText5.perform(replaceText("5"), closeSoftKeyboard());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.editOfferYearlyBonus),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        5),
                                1),
                        isDisplayed()));
        appCompatEditText6.perform(replaceText("5"), closeSoftKeyboard());

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.editOfferRSU),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        6),
                                1),
                        isDisplayed()));
        appCompatEditText7.perform(replaceText("5"), closeSoftKeyboard());

        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.editOfferRelocation),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        7),
                                1),
                        isDisplayed()));
        appCompatEditText8.perform(replaceText("5"), closeSoftKeyboard());

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
        appCompatEditText11.perform(replaceText("google"), closeSoftKeyboard());

        ViewInteraction appCompatEditText12 = onView(
                allOf(withId(R.id.editOfferLocation),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        2),
                                1),
                        isDisplayed()));
        appCompatEditText12.perform(replaceText("wrgfoi, CA"), closeSoftKeyboard());

        ViewInteraction appCompatEditText13 = onView(
                allOf(withId(R.id.editOfferLivingCost),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        3),
                                1),
                        isDisplayed()));
        appCompatEditText13.perform(replaceText("100"), closeSoftKeyboard());

        ViewInteraction appCompatEditText14 = onView(
                allOf(withId(R.id.editOfferYearlySalary),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        4),
                                1),
                        isDisplayed()));
        appCompatEditText14.perform(replaceText("1000000"), closeSoftKeyboard());

        ViewInteraction appCompatEditText15 = onView(
                allOf(withId(R.id.editOfferYearlyBonus),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        5),
                                1),
                        isDisplayed()));
        appCompatEditText15.perform(replaceText("100000"), closeSoftKeyboard());

        ViewInteraction appCompatEditText16 = onView(
                allOf(withId(R.id.editOfferRSU),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        6),
                                1),
                        isDisplayed()));
        appCompatEditText16.perform(replaceText("5"), closeSoftKeyboard());

        ViewInteraction appCompatEditText17 = onView(
                allOf(withId(R.id.editOfferRelocation),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        7),
                                1),
                        isDisplayed()));
        appCompatEditText17.perform(replaceText("5"), closeSoftKeyboard());

        ViewInteraction appCompatEditText18 = onView(
                allOf(withId(R.id.editOfferHolidays),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        8),
                                1),
                        isDisplayed()));
        appCompatEditText18.perform(replaceText("5"), closeSoftKeyboard());

        ViewInteraction materialButton4 = onView(
                allOf(withId(R.id.btnOfferSave), withText("Save"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        2),
                                0),
                        isDisplayed()));
        materialButton4.perform(click());

        ViewInteraction appCompatTextView = onView(
                allOf(withId(R.id.tvTitle2), withText("Home Screen"),
                        childAtPosition(
                                childAtPosition(
                                        withId(androidx.appcompat.R.id.action_bar),
                                        0),
                                1),
                        isDisplayed()));
        appCompatTextView.perform(click());

        ViewInteraction materialButton5 = onView(
                allOf(withId(R.id.btnCompareJobs), withText("Compare Job Offers"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        0),
                                3),
                        isDisplayed()));
        materialButton5.perform(click());

        ViewInteraction checkBox = onView(
                allOf(childAtPosition(
                                childAtPosition(
                                        withId(R.id.compareJobsTableID),
                                        1),
                                0),
                        isDisplayed()));
        checkBox.perform(click());

        ViewInteraction materialButton6 = onView(
                allOf(withId(R.id.btnOfferCompare), withText("Edit"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        3),
                                1),
                        isDisplayed()));
        materialButton6.perform(click());

        ViewInteraction appCompatEditText19 = onView(
                allOf(withId(R.id.editOfferTitle), withText("ML"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText19.perform(replaceText("ML Engineer"));

        ViewInteraction appCompatEditText20 = onView(
                allOf(withId(R.id.editOfferTitle), withText("ML Engineer"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText20.perform(closeSoftKeyboard());

        ViewInteraction materialButton7 = onView(
                allOf(withId(R.id.btnOfferSave), withText("Save"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        2),
                                0),
                        isDisplayed()));
        materialButton7.perform(click());

        ViewInteraction appCompatTextView2 = onView(
                allOf(withId(R.id.tvTitle2), withText("Home Screen"),
                        childAtPosition(
                                childAtPosition(
                                        withId(androidx.appcompat.R.id.action_bar),
                                        0),
                                1),
                        isDisplayed()));
        appCompatTextView2.perform(click());

        ViewInteraction materialButton8 = onView(
                allOf(withId(R.id.btnCompareJobs), withText("Compare Job Offers"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        0),
                                3),
                        isDisplayed()));
        materialButton8.perform(click());

        ViewInteraction textView = onView(
                allOf(withText("ML Engineer"),
                        withParent(withParent(withId(R.id.compareJobsTableID))),
                        isDisplayed()));
        textView.check(matches(withText("ML Engineer")));
    }

    @Test
    public void deleteTooManyTest() {
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

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.editOfferCompany),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        1),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("wefg"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.editOfferLocation),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        2),
                                1),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText("sdf,tx"), closeSoftKeyboard());

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
        appCompatEditText5.perform(replaceText("5"), closeSoftKeyboard());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.editOfferYearlyBonus),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        5),
                                1),
                        isDisplayed()));
        appCompatEditText6.perform(replaceText("5"), closeSoftKeyboard());

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.editOfferRSU),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        6),
                                1),
                        isDisplayed()));
        appCompatEditText7.perform(replaceText("5"), closeSoftKeyboard());

        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.editOfferRelocation),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        7),
                                1),
                        isDisplayed()));
        appCompatEditText8.perform(replaceText("5"), closeSoftKeyboard());

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
        appCompatEditText11.perform(replaceText("google"), closeSoftKeyboard());

        ViewInteraction appCompatEditText12 = onView(
                allOf(withId(R.id.editOfferLocation),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        2),
                                1),
                        isDisplayed()));
        appCompatEditText12.perform(replaceText("wrgfoi, CA"), closeSoftKeyboard());

        ViewInteraction appCompatEditText13 = onView(
                allOf(withId(R.id.editOfferLivingCost),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        3),
                                1),
                        isDisplayed()));
        appCompatEditText13.perform(replaceText("100"), closeSoftKeyboard());

        ViewInteraction appCompatEditText14 = onView(
                allOf(withId(R.id.editOfferYearlySalary),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        4),
                                1),
                        isDisplayed()));
        appCompatEditText14.perform(replaceText("1000000"), closeSoftKeyboard());

        ViewInteraction appCompatEditText15 = onView(
                allOf(withId(R.id.editOfferYearlyBonus),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        5),
                                1),
                        isDisplayed()));
        appCompatEditText15.perform(replaceText("100000"), closeSoftKeyboard());

        ViewInteraction appCompatEditText16 = onView(
                allOf(withId(R.id.editOfferRSU),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        6),
                                1),
                        isDisplayed()));
        appCompatEditText16.perform(replaceText("5"), closeSoftKeyboard());

        ViewInteraction appCompatEditText17 = onView(
                allOf(withId(R.id.editOfferRelocation),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        7),
                                1),
                        isDisplayed()));
        appCompatEditText17.perform(replaceText("5"), closeSoftKeyboard());

        ViewInteraction appCompatEditText18 = onView(
                allOf(withId(R.id.editOfferHolidays),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        8),
                                1),
                        isDisplayed()));
        appCompatEditText18.perform(replaceText("5"), closeSoftKeyboard());

        ViewInteraction materialButton4 = onView(
                allOf(withId(R.id.btnOfferSave), withText("Save"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        2),
                                0),
                        isDisplayed()));
        materialButton4.perform(click());

        ViewInteraction appCompatTextView = onView(
                allOf(withId(R.id.tvTitle2), withText("Home Screen"),
                        childAtPosition(
                                childAtPosition(
                                        withId(androidx.appcompat.R.id.action_bar),
                                        0),
                                1),
                        isDisplayed()));
        appCompatTextView.perform(click());

        ViewInteraction materialButton5 = onView(
                allOf(withId(R.id.btnCompareJobs), withText("Compare Job Offers"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        0),
                                3),
                        isDisplayed()));
        materialButton5.perform(click());

        ViewInteraction checkBox = onView(
                allOf(childAtPosition(
                                childAtPosition(
                                        withId(R.id.compareJobsTableID),
                                        1),
                                0),
                        isDisplayed()));
        checkBox.perform(click());

        ViewInteraction materialButton6 = onView(
                allOf(withId(R.id.btnOfferCompare), withText("Edit"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        3),
                                1),
                        isDisplayed()));
        materialButton6.perform(click());

        ViewInteraction appCompatEditText19 = onView(
                allOf(withId(R.id.editOfferTitle), withText("ML"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText19.perform(replaceText("ML Engineer"));

        ViewInteraction appCompatEditText20 = onView(
                allOf(withId(R.id.editOfferTitle), withText("ML Engineer"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText20.perform(closeSoftKeyboard());

        ViewInteraction materialButton7 = onView(
                allOf(withId(R.id.btnOfferSave), withText("Save"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        2),
                                0),
                        isDisplayed()));
        materialButton7.perform(click());

        ViewInteraction appCompatTextView2 = onView(
                allOf(withId(R.id.tvTitle2), withText("Home Screen"),
                        childAtPosition(
                                childAtPosition(
                                        withId(androidx.appcompat.R.id.action_bar),
                                        0),
                                1),
                        isDisplayed()));
        appCompatTextView2.perform(click());

        ViewInteraction materialButton8 = onView(
                allOf(withId(R.id.btnCompareJobs), withText("Compare Job Offers"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        0),
                                3),
                        isDisplayed()));
        materialButton8.perform(click());

        ViewInteraction checkBox2 = onView(
                allOf(childAtPosition(
                                childAtPosition(
                                        withId(R.id.compareJobsTableID),
                                        1),
                                0),
                        isDisplayed()));
        checkBox2.perform(click());

        ViewInteraction materialButton9 = onView(
                allOf(withId(R.id.btnNewOffer), withText("Delete"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        3),
                                0),
                        isDisplayed()));
        materialButton9.perform(click());

        ViewInteraction materialButton10 = onView(
                allOf(withId(android.R.id.button1), withText("Yes"),
                        childAtPosition(
                                childAtPosition(
                                        withId(androidx.appcompat.R.id.buttonPanel),
                                        0),
                                3)));
        materialButton10.perform(scrollTo(), click());

        ViewInteraction materialButton11 = onView(
                allOf(withId(R.id.btnCompareJobs), withText("Compare Job Offers"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        0),
                                3),
                        isDisplayed()));
        materialButton11.perform(click());
    }

    @Test
    public void editCurrentJobTest() {
        ViewInteraction materialButton = onView(
                allOf(withId(R.id.btnCurrentJob), withText("Enter/Edit Current Job"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        0),
                                0),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.editTextTitle),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("Cat"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.editTextCompany),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        1),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("Seuss"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.editTextLocation),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        2),
                                1),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText("nowhere,tx"), closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.editTextLivingCost),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        3),
                                1),
                        isDisplayed()));
        appCompatEditText4.perform(replaceText("5"), closeSoftKeyboard());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.editTextYearlySalary),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        4),
                                1),
                        isDisplayed()));
        appCompatEditText5.perform(replaceText("10"), closeSoftKeyboard());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.editTextYearlyBonus),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        5),
                                1),
                        isDisplayed()));
        appCompatEditText6.perform(replaceText("10"), closeSoftKeyboard());

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.editTextRSU),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        6),
                                1),
                        isDisplayed()));
        appCompatEditText7.perform(replaceText("10"), closeSoftKeyboard());

        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.editTextRelocation),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        7),
                                1),
                        isDisplayed()));
        appCompatEditText8.perform(replaceText("10"), closeSoftKeyboard());

        ViewInteraction appCompatEditText9 = onView(
                allOf(withId(R.id.editTextHolidays),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        8),
                                1),
                        isDisplayed()));
        appCompatEditText9.perform(replaceText("10"), closeSoftKeyboard());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.curJobSave), withText("Save"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        2),
                                0),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction materialButton3 = onView(
                allOf(withId(R.id.btnJobOffer), withText("Enter Job Offers"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        0),
                                1),
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
        appCompatEditText10.perform(replaceText("Hat"), closeSoftKeyboard());

        ViewInteraction appCompatEditText11 = onView(
                allOf(withId(R.id.editOfferCompany),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        1),
                                1),
                        isDisplayed()));
        appCompatEditText11.perform(replaceText("Seuss"), closeSoftKeyboard());

        ViewInteraction appCompatEditText12 = onView(
                allOf(withId(R.id.editOfferLocation),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        2),
                                1),
                        isDisplayed()));
        appCompatEditText12.perform(replaceText("somehwere, u"), closeSoftKeyboard());

        ViewInteraction appCompatEditText13 = onView(
                allOf(withId(R.id.editOfferLivingCost),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        3),
                                1),
                        isDisplayed()));
        appCompatEditText13.perform(replaceText("8"), closeSoftKeyboard());

        ViewInteraction appCompatEditText14 = onView(
                allOf(withId(R.id.editOfferYearlySalary),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        4),
                                1),
                        isDisplayed()));
        appCompatEditText14.perform(replaceText("70"), closeSoftKeyboard());

        ViewInteraction appCompatEditText15 = onView(
                allOf(withId(R.id.editOfferYearlyBonus),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        5),
                                1),
                        isDisplayed()));
        appCompatEditText15.perform(replaceText("2"), closeSoftKeyboard());

        ViewInteraction appCompatEditText16 = onView(
                allOf(withId(R.id.editOfferRSU),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        6),
                                1),
                        isDisplayed()));
        appCompatEditText16.perform(replaceText("2"), closeSoftKeyboard());

        ViewInteraction appCompatEditText17 = onView(
                allOf(withId(R.id.editOfferRelocation),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        7),
                                1),
                        isDisplayed()));
        appCompatEditText17.perform(replaceText("2"), closeSoftKeyboard());

        ViewInteraction appCompatEditText18 = onView(
                allOf(withId(R.id.editOfferHolidays),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        8),
                                1),
                        isDisplayed()));
        appCompatEditText18.perform(replaceText("2"), closeSoftKeyboard());

        ViewInteraction materialButton4 = onView(
                allOf(withId(R.id.btnOfferSave), withText("Save"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        2),
                                0),
                        isDisplayed()));
        materialButton4.perform(click());

        ViewInteraction materialButton5 = onView(
                allOf(withId(R.id.btnNewOffer), withText("New Offer"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        3),
                                0),
                        isDisplayed()));
        materialButton5.perform(click());

        ViewInteraction appCompatEditText19 = onView(
                allOf(withId(R.id.editOfferTitle),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText19.perform(replaceText("Writer"), closeSoftKeyboard());

        ViewInteraction appCompatEditText20 = onView(
                allOf(withId(R.id.editOfferCompany),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        1),
                                1),
                        isDisplayed()));
        appCompatEditText20.perform(replaceText("NYT"), closeSoftKeyboard());

        ViewInteraction appCompatEditText21 = onView(
                allOf(withId(R.id.editOfferLocation),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        2),
                                1),
                        isDisplayed()));
        appCompatEditText21.perform(replaceText("m,m"), closeSoftKeyboard());

        ViewInteraction appCompatEditText22 = onView(
                allOf(withId(R.id.editOfferLivingCost),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        3),
                                1),
                        isDisplayed()));
        appCompatEditText22.perform(replaceText("100"), closeSoftKeyboard());

        ViewInteraction appCompatEditText23 = onView(
                allOf(withId(R.id.editOfferYearlySalary),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        4),
                                1),
                        isDisplayed()));
        appCompatEditText23.perform(replaceText("100000"), closeSoftKeyboard());

        ViewInteraction appCompatEditText24 = onView(
                allOf(withId(R.id.editOfferYearlyBonus),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        5),
                                1),
                        isDisplayed()));
        appCompatEditText24.perform(replaceText("10"), closeSoftKeyboard());

        ViewInteraction appCompatEditText25 = onView(
                allOf(withId(R.id.editOfferRSU),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        6),
                                1),
                        isDisplayed()));
        appCompatEditText25.perform(replaceText("5"), closeSoftKeyboard());

        ViewInteraction appCompatEditText26 = onView(
                allOf(withId(R.id.editOfferRelocation),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        7),
                                1),
                        isDisplayed()));
        appCompatEditText26.perform(replaceText("5"), closeSoftKeyboard());

        ViewInteraction appCompatEditText27 = onView(
                allOf(withId(R.id.editOfferHolidays),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        8),
                                1),
                        isDisplayed()));
        appCompatEditText27.perform(replaceText("5"), closeSoftKeyboard());

        ViewInteraction materialButton6 = onView(
                allOf(withId(R.id.btnOfferSave), withText("Save"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        2),
                                0),
                        isDisplayed()));
        materialButton6.perform(click());

        ViewInteraction appCompatTextView = onView(
                allOf(withId(R.id.tvTitle2), withText("Home Screen"),
                        childAtPosition(
                                childAtPosition(
                                        withId(androidx.appcompat.R.id.action_bar),
                                        0),
                                1),
                        isDisplayed()));
        appCompatTextView.perform(click());

        ViewInteraction materialButton7 = onView(
                allOf(withId(R.id.btnCompareJobs), withText("Compare Job Offers"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        0),
                                3),
                        isDisplayed()));
        materialButton7.perform(click());

        ViewInteraction checkBox = onView(
                allOf(childAtPosition(
                                childAtPosition(
                                        withId(R.id.compareJobsTableID),
                                        3),
                                0),
                        isDisplayed()));
        checkBox.perform(click());

        ViewInteraction materialButton8 = onView(
                allOf(withId(R.id.btnOfferCompare), withText("Edit"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        3),
                                1),
                        isDisplayed()));
        materialButton8.perform(click());

        ViewInteraction appCompatEditText28 = onView(
                allOf(withId(R.id.editTextYearlySalary), withText("10.00"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        4),
                                1),
                        isDisplayed()));
        appCompatEditText28.perform(replaceText("500000"));

        ViewInteraction appCompatEditText29 = onView(
                allOf(withId(R.id.editTextYearlySalary), withText("500000"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        4),
                                1),
                        isDisplayed()));
        appCompatEditText29.perform(closeSoftKeyboard());

        ViewInteraction appCompatEditText30 = onView(
                allOf(withId(R.id.editTextTitle), withText("Cat"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText30.perform(replaceText("Cat Hat"));

        ViewInteraction appCompatEditText31 = onView(
                allOf(withId(R.id.editTextTitle), withText("Cat Hat"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText31.perform(closeSoftKeyboard());

        ViewInteraction materialButton9 = onView(
                allOf(withId(R.id.curJobSave), withText("Save"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        2),
                                0),
                        isDisplayed()));
        materialButton9.perform(click());

        ViewInteraction materialButton10 = onView(
                allOf(withId(R.id.btnCompareJobs), withText("Compare Job Offers"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        0),
                                3),
                        isDisplayed()));
        materialButton10.perform(click());

        ViewInteraction textView = onView(
                allOf(withText("Cat Hat"),
                        withParent(withParent(withId(R.id.compareJobsTableID))),
                        isDisplayed()));
        textView.check(matches(withText("Cat Hat")));
    }

    @Test
    public void deleteSingleJobTest() {
        ViewInteraction materialButton = onView(
                allOf(withId(R.id.btnCurrentJob), withText("Enter/Edit Current Job"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        0),
                                0),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.editTextTitle),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("Cat"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.editTextCompany),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        1),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("Seuss"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.editTextLocation),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        2),
                                1),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText("nowhere,tx"), closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.editTextLivingCost),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        3),
                                1),
                        isDisplayed()));
        appCompatEditText4.perform(replaceText("5"), closeSoftKeyboard());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.editTextYearlySalary),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        4),
                                1),
                        isDisplayed()));
        appCompatEditText5.perform(replaceText("10"), closeSoftKeyboard());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.editTextYearlyBonus),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        5),
                                1),
                        isDisplayed()));
        appCompatEditText6.perform(replaceText("10"), closeSoftKeyboard());

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.editTextRSU),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        6),
                                1),
                        isDisplayed()));
        appCompatEditText7.perform(replaceText("10"), closeSoftKeyboard());

        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.editTextRelocation),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        7),
                                1),
                        isDisplayed()));
        appCompatEditText8.perform(replaceText("10"), closeSoftKeyboard());

        ViewInteraction appCompatEditText9 = onView(
                allOf(withId(R.id.editTextHolidays),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        8),
                                1),
                        isDisplayed()));
        appCompatEditText9.perform(replaceText("10"), closeSoftKeyboard());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.curJobSave), withText("Save"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        2),
                                0),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction materialButton3 = onView(
                allOf(withId(R.id.btnJobOffer), withText("Enter Job Offers"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        0),
                                1),
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
        appCompatEditText10.perform(replaceText("Hat"), closeSoftKeyboard());

        ViewInteraction appCompatEditText11 = onView(
                allOf(withId(R.id.editOfferCompany),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        1),
                                1),
                        isDisplayed()));
        appCompatEditText11.perform(replaceText("Seuss"), closeSoftKeyboard());

        ViewInteraction appCompatEditText12 = onView(
                allOf(withId(R.id.editOfferLocation),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        2),
                                1),
                        isDisplayed()));
        appCompatEditText12.perform(replaceText("somehwere, u"), closeSoftKeyboard());

        ViewInteraction appCompatEditText13 = onView(
                allOf(withId(R.id.editOfferLivingCost),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        3),
                                1),
                        isDisplayed()));
        appCompatEditText13.perform(replaceText("8"), closeSoftKeyboard());

        ViewInteraction appCompatEditText14 = onView(
                allOf(withId(R.id.editOfferYearlySalary),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        4),
                                1),
                        isDisplayed()));
        appCompatEditText14.perform(replaceText("70"), closeSoftKeyboard());

        ViewInteraction appCompatEditText15 = onView(
                allOf(withId(R.id.editOfferYearlyBonus),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        5),
                                1),
                        isDisplayed()));
        appCompatEditText15.perform(replaceText("2"), closeSoftKeyboard());

        ViewInteraction appCompatEditText16 = onView(
                allOf(withId(R.id.editOfferRSU),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        6),
                                1),
                        isDisplayed()));
        appCompatEditText16.perform(replaceText("2"), closeSoftKeyboard());

        ViewInteraction appCompatEditText17 = onView(
                allOf(withId(R.id.editOfferRelocation),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        7),
                                1),
                        isDisplayed()));
        appCompatEditText17.perform(replaceText("2"), closeSoftKeyboard());

        ViewInteraction appCompatEditText18 = onView(
                allOf(withId(R.id.editOfferHolidays),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        8),
                                1),
                        isDisplayed()));
        appCompatEditText18.perform(replaceText("2"), closeSoftKeyboard());

        ViewInteraction materialButton4 = onView(
                allOf(withId(R.id.btnOfferSave), withText("Save"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        2),
                                0),
                        isDisplayed()));
        materialButton4.perform(click());

        ViewInteraction materialButton5 = onView(
                allOf(withId(R.id.btnNewOffer), withText("New Offer"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        3),
                                0),
                        isDisplayed()));
        materialButton5.perform(click());

        ViewInteraction appCompatEditText19 = onView(
                allOf(withId(R.id.editOfferTitle),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText19.perform(replaceText("Writer"), closeSoftKeyboard());

        ViewInteraction appCompatEditText20 = onView(
                allOf(withId(R.id.editOfferCompany),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        1),
                                1),
                        isDisplayed()));
        appCompatEditText20.perform(replaceText("NYT"), closeSoftKeyboard());

        ViewInteraction appCompatEditText21 = onView(
                allOf(withId(R.id.editOfferLocation),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        2),
                                1),
                        isDisplayed()));
        appCompatEditText21.perform(replaceText("m,m"), closeSoftKeyboard());

        ViewInteraction appCompatEditText22 = onView(
                allOf(withId(R.id.editOfferLivingCost),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        3),
                                1),
                        isDisplayed()));
        appCompatEditText22.perform(replaceText("100"), closeSoftKeyboard());

        ViewInteraction appCompatEditText23 = onView(
                allOf(withId(R.id.editOfferYearlySalary),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        4),
                                1),
                        isDisplayed()));
        appCompatEditText23.perform(replaceText("100000"), closeSoftKeyboard());

        ViewInteraction appCompatEditText24 = onView(
                allOf(withId(R.id.editOfferYearlyBonus),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        5),
                                1),
                        isDisplayed()));
        appCompatEditText24.perform(replaceText("10"), closeSoftKeyboard());

        ViewInteraction appCompatEditText25 = onView(
                allOf(withId(R.id.editOfferRSU),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        6),
                                1),
                        isDisplayed()));
        appCompatEditText25.perform(replaceText("5"), closeSoftKeyboard());

        ViewInteraction appCompatEditText26 = onView(
                allOf(withId(R.id.editOfferRelocation),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        7),
                                1),
                        isDisplayed()));
        appCompatEditText26.perform(replaceText("5"), closeSoftKeyboard());

        ViewInteraction appCompatEditText27 = onView(
                allOf(withId(R.id.editOfferHolidays),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        8),
                                1),
                        isDisplayed()));
        appCompatEditText27.perform(replaceText("5"), closeSoftKeyboard());

        ViewInteraction materialButton6 = onView(
                allOf(withId(R.id.btnOfferSave), withText("Save"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        2),
                                0),
                        isDisplayed()));
        materialButton6.perform(click());

        ViewInteraction appCompatTextView = onView(
                allOf(withId(R.id.tvTitle2), withText("Home Screen"),
                        childAtPosition(
                                childAtPosition(
                                        withId(androidx.appcompat.R.id.action_bar),
                                        0),
                                1),
                        isDisplayed()));
        appCompatTextView.perform(click());

        ViewInteraction materialButton7 = onView(
                allOf(withId(R.id.btnCompareJobs), withText("Compare Job Offers"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        0),
                                3),
                        isDisplayed()));
        materialButton7.perform(click());

        ViewInteraction checkBox = onView(
                allOf(childAtPosition(
                                childAtPosition(
                                        withId(R.id.compareJobsTableID),
                                        3),
                                0),
                        isDisplayed()));
        checkBox.perform(click());

        ViewInteraction materialButton8 = onView(
                allOf(withId(R.id.btnOfferCompare), withText("Edit"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        3),
                                1),
                        isDisplayed()));
        materialButton8.perform(click());

        ViewInteraction appCompatEditText28 = onView(
                allOf(withId(R.id.editTextYearlySalary), withText("10.00"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        4),
                                1),
                        isDisplayed()));
        appCompatEditText28.perform(replaceText("500000"));

        ViewInteraction appCompatEditText29 = onView(
                allOf(withId(R.id.editTextYearlySalary), withText("500000"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        4),
                                1),
                        isDisplayed()));
        appCompatEditText29.perform(closeSoftKeyboard());

        ViewInteraction appCompatEditText30 = onView(
                allOf(withId(R.id.editTextTitle), withText("Cat"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText30.perform(replaceText("Cat Hat"));

        ViewInteraction appCompatEditText31 = onView(
                allOf(withId(R.id.editTextTitle), withText("Cat Hat"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.TableLayout")),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText31.perform(closeSoftKeyboard());

        ViewInteraction materialButton9 = onView(
                allOf(withId(R.id.curJobSave), withText("Save"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        2),
                                0),
                        isDisplayed()));
        materialButton9.perform(click());

        ViewInteraction materialButton10 = onView(
                allOf(withId(R.id.btnCompareJobs), withText("Compare Job Offers"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        0),
                                3),
                        isDisplayed()));
        materialButton10.perform(click());

        ViewInteraction textView = onView(
                allOf(withText("Cat Hat"),
                        withParent(withParent(withId(R.id.compareJobsTableID))),
                        isDisplayed()));
        textView.check(matches(withText("Cat Hat")));

        ViewInteraction checkBox2 = onView(
                allOf(childAtPosition(
                                childAtPosition(
                                        withId(R.id.compareJobsTableID),
                                        1),
                                0),
                        isDisplayed()));
        checkBox2.perform(click());

        ViewInteraction materialButton11 = onView(
                allOf(withId(R.id.btnNewOffer), withText("Delete"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        3),
                                0),
                        isDisplayed()));
        materialButton11.perform(click());

        ViewInteraction materialButton12 = onView(
                allOf(withId(android.R.id.button1), withText("Yes"),
                        childAtPosition(
                                childAtPosition(
                                        withId(androidx.appcompat.R.id.buttonPanel),
                                        0),
                                3)));
        materialButton12.perform(scrollTo(), click());

        ViewInteraction textView2 = onView(
                allOf(withText("Writer"),
                        withParent(withParent(withId(R.id.compareJobsTableID))),
                        isDisplayed()));
        textView2.check(matches(withText("Writer")));

        ViewInteraction materialButton13 = onView(
                allOf(withId(R.id.compareJobsCancel), withText("Cancel"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        2),
                                1),
                        isDisplayed()));
        materialButton13.perform(click());
    }

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
