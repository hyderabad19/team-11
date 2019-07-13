<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
xmlns:app="http://schemas.android.com/apk/res-auto"
xmlns:tools="http://schemas.android.com/tools"
android:layout_width="match_parent"
android:layout_height="match_parent"
tools:context=".MainActivity">

<LinearLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_alignParentTop="true"
    android:layout_marginTop="10dp"
    android:orientation="vertical"
    android:layout_marginHorizontal="10dp"
    tools:layout_editor_absoluteX="16dp"
    tools:layout_editor_absoluteY="115dp">

    <EditText
        android:id="@+id/name"
        android:layout_width="match_parent"
        android:layout_height="20dp"
        android:layout_margin="15dp"
        android:background="#00BCD4"
        android:hint="Enter your name"
        android:inputType="text" />

    <EditText
        android:id="@+id/email"
        android:layout_width="match_parent"
        android:layout_height="20dp"
        android:layout_margin="15dp"
        android:background="#00BCD4"
        android:hint="Enter your email"
        android:inputType="textEmailAddress" />

    <EditText
        android:id="@+id/password"
        android:layout_width="match_parent"
        android:layout_height="20dp"
        android:layout_margin="15dp"
        android:background="#00BCD4"
        android:hint="Enter your password"
        android:inputType="textPassword" />

    <EditText
        android:id="@+id/mobile"
        android:layout_width="match_parent"
        android:layout_height="20dp"
        android:layout_margin="15dp"
        android:background="#00BCD4"
        android:ems="10"
        android:hint="Enter your mobile no"
        android:inputType="phone"
        android:textColorLink="#00BCD4" />

    <EditText
        android:id="@+id/gender"
        android:layout_width="match_parent"
        android:layout_height="20dp"
        android:layout_margin="15dp"
        android:background="#00BCD4"
        android:hint="Enter your Gender"
        android:inputType="text" />


    <EditText
        android:id="@+id/DOB"
        android:layout_width="match_parent"
        android:layout_height="20dp"
        android:layout_margin="15dp"
        android:background="#00BCD4"
        android:hint="Enter your date of birth"
        android:inputType="date" />


    <Button

        android:id="@+id/buttonRegister"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_margin="15dp"
        android:text="Register User"/>


</LinearLayout>


</RelativeLayout>
