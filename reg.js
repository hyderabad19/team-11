<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:clipToPadding="true"
    tools:context=".MainActivity"
    android:background="@drawable/img">

    <TextView
        android:id="@+id/textView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_alignParentEnd="true"
        android:layout_alignParentBottom="true"
        android:layout_marginEnd="-2dp"
        android:layout_marginBottom="660dp"
        android:text="          DR.REDDY'S FOUNDATION"
        android:textColor="#3F51B5"
        android:textSize="24sp" />


    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:layout_marginHorizontal="10dp"
        android:layout_marginTop="98dp"
        android:orientation="vertical"
        tools:layout_editor_absoluteX="16dp"
        tools:layout_editor_absoluteY="115dp">

        <EditText
            android:id="@+id/name"
            android:layout_width="match_parent"
            android:layout_height="20dp"
            android:layout_margin="15dp"
            android:background="#D3D1CA"
            android:hint="Enter your name"
            android:inputType="text" />

        <EditText
            android:id="@+id/email"
            android:layout_width="match_parent"
            android:layout_height="20dp"
            android:layout_margin="15dp"
            android:background="#D3D1CA"
            android:hint="email"
            android:inputType="textEmailAddress" />

        <EditText
            android:id="@+id/password"
            android:layout_width="match_parent"
            android:layout_height="20dp"
            android:layout_alignEnd="@+id/null"
            android:layout_margin="15dp"
            android:background="#D3D1CA"
            android:hint="password"
            android:inputType="textPassword" />

        <EditText
            android:id="@+id/mobile"
            android:layout_width="match_parent"
            android:layout_height="20dp"
            android:layout_margin="15dp"
            android:background="#D3D1CA"
            android:ems="10"
            android:hint="mobile no"
            android:inputType="phone"
            android:textColorLink="#00BCD4" />

        <EditText
            android:id="@+id/gender"
            android:layout_width="match_parent"
            android:layout_height="20dp"
            android:layout_margin="15dp"
            android:background="#D3D1CA"
            android:hint="Gender"
            android:inputType="text" />


        <EditText
            android:id="@+id/DOB"
            android:layout_width="match_parent"
            android:layout_height="20dp"
            android:layout_margin="15dp"
            android:background="#D3D1CA"
            android:hint="date of birth"
            android:inputType="date" />


        <Button

            android:id="@+id/buttonRegister"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="15dp"
            android:text="Register User" />


    </LinearLayout>


</RelativeLayout>
