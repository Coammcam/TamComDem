package com.xuong.poly.hoangcam.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.xuong.poly.hoangcam.screen.admin.AdminAddCategory
import com.xuong.poly.hoangcam.screen.admin.AdminAddDish
import com.xuong.poly.hoangcam.screen.admin.AdminDeleteCategory
import com.xuong.poly.hoangcam.screen.admin.AdminDeleteDish
import com.xuong.poly.hoangcam.screen.admin.AdminEditCategory
import com.xuong.poly.hoangcam.screen.admin.AdminEditDish
import com.xuong.poly.hoangcam.screen.admin.AdminHistory
import com.xuong.poly.hoangcam.screen.admin.AdminHomeView
import com.xuong.poly.hoangcam.screen.admin.AdminManager
import com.xuong.poly.hoangcam.screen.admin.AdminManagerCategories
import com.xuong.poly.hoangcam.screen.admin.AdminManagerDish
import com.xuong.poly.hoangcam.screen.admin.AdminSupport
import com.xuong.poly.hoangcam.screen.user.Boarding
import com.xuong.poly.hoangcam.screen.user.Login
import com.xuong.poly.hoangcam.screen.user.MainView
import com.xuong.poly.hoangcam.screen.user.UpdateInfo

enum class ROUTE_SCREEN_NAME {
    BOARDING, LOGIN, SIGNUP, OTP, HOMESCREEN, CARTHISTORY, CARTHISTORYWITHOUTBILLS, BILLDETAIL, PAYMENT, PROFILE, ADMINHOME, ADMINMANAGER, ADMINADDCATEGORY, ADMINMANAGECATEGORY, ADMINMANAGERDISH, ADMINHISTORY, ADMINSUPPORT, ADMINEDITCATEGORY, ADMINDELETECATEGORY, ADMINADDDISH, ADMINEDITDISH, ADMINDELETEDISH
}

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = ROUTE_SCREEN_NAME.BOARDING.name
) {
    NavHost(
        navController = navController, modifier = Modifier, startDestination = startDestination
    ) {
        composable(ROUTE_SCREEN_NAME.BOARDING.name) {
            Boarding(navController)
        }

        composable(ROUTE_SCREEN_NAME.LOGIN.name) {
            Login(navController)
        }

        composable(ROUTE_SCREEN_NAME.SIGNUP.name) {
            UpdateInfo(navController)
        }

        composable(ROUTE_SCREEN_NAME.HOMESCREEN.name) {
            MainView(modifier, navController)
        }

        composable(ROUTE_SCREEN_NAME.ADMINHOME.name) {
            AdminHomeView(modifier, navController)
        }

        composable(ROUTE_SCREEN_NAME.ADMINMANAGER.name) {
            AdminManager(navController)
        }

        composable(ROUTE_SCREEN_NAME.ADMINADDCATEGORY.name) {
            AdminAddCategory(navController)
        }

        composable(ROUTE_SCREEN_NAME.ADMINMANAGECATEGORY.name) {
            AdminManagerCategories(navController)
        }

        composable(ROUTE_SCREEN_NAME.ADMINMANAGERDISH.name) {
            AdminManagerDish(navController)
        }

        composable(ROUTE_SCREEN_NAME.ADMINHISTORY.name) {
            AdminHistory(navController)
        }

        composable(ROUTE_SCREEN_NAME.ADMINSUPPORT.name) {
            AdminSupport(navController)
        }
        composable(ROUTE_SCREEN_NAME.ADMINEDITCATEGORY.name) {
            AdminEditCategory(navController)
        }

        composable(ROUTE_SCREEN_NAME.ADMINDELETECATEGORY.name) {
            AdminDeleteCategory(navController)
        }

        composable(ROUTE_SCREEN_NAME.ADMINADDDISH.name) {
            AdminAddDish(navController)
        }

        composable(ROUTE_SCREEN_NAME.ADMINEDITDISH.name) {
            AdminEditDish(navController)
        }

        composable(ROUTE_SCREEN_NAME.ADMINDELETEDISH.name) {
            AdminDeleteDish(navController)
        }
    }
}