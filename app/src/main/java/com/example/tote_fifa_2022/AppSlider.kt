package com.example.tote_fifa_2022.ui.objects

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.View
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getColor
import com.example.tote_fifa_2022.R
import com.example.tote_fifa_2022.utilits.APP_ACTIVITY
import com.mikepenz.iconics.typeface.library.fontawesome.FontAwesome
import com.mikepenz.iconics.typeface.library.fontawesome.FontAwesome.Icon.*
import com.mikepenz.materialdrawer.iconics.iconicsIcon
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.descriptionText
import com.mikepenz.materialdrawer.model.interfaces.nameRes
import com.mikepenz.materialdrawer.model.interfaces.nameText
import com.mikepenz.materialdrawer.util.addStickyFooterItem
import com.mikepenz.materialdrawer.widget.AccountHeaderView

class AppSlider() {
    private lateinit var mHeader: AccountHeaderView

    fun create() {
        //initImageLoader()
        createSlider()
        createHeader()
    }

    private fun createSlider() {
        //APP_ACTIVITY.mSlider.customWidth = 400
        APP_ACTIVITY.mSlider.itemAdapter.clear()

        val test = false

        APP_ACTIVITY.mSlider.itemAdapter.add(
            PrimaryDrawerItem().apply {
                //iconColor = ColorStateList.valueOf(ContextCompat.getColor(APP_ACTIVITY, R.color.application))
                nameRes = R.string.gamblers;
                iconicsIcon = faw_users;

                identifier = 100
            },
            PrimaryDrawerItem().apply {
                nameRes = R.string.games;
                iconicsIcon = FontAwesome.Icon.faw_futbol;
                identifier = 101
            },
            PrimaryDrawerItem().apply {
                nameRes = R.string.prognosis;
                iconicsIcon = faw_money_check;
                identifier = 102
            },
            PrimaryDrawerItem().apply {
                nameRes = R.string.totalizator;
                iconicsIcon = faw_ruble_sign;
                identifier = 103
            },
            PrimaryDrawerItem().apply {
                nameRes = R.string.winners;
                iconicsIcon = faw_trophy;
                identifier = 104
            }
        )

        if (!test) {
            APP_ACTIVITY.mSlider.itemAdapter.add(
                DividerDrawerItem(),
                SecondaryDrawerItem().apply {
                    nameText = "Админка"
                    textColor = ColorStateList.valueOf(ContextCompat.getColor(APP_ACTIVITY, R.color.black))
                    isEnabled = false
                },
                DividerDrawerItem(),
                PrimaryDrawerItem().apply {
                    nameRes = R.string.emails;
                    iconicsIcon = FontAwesome.Icon.faw_at;
                    identifier = 200
                },
                PrimaryDrawerItem().apply {
                    nameRes = R.string.games;
                    iconicsIcon = FontAwesome.Icon.faw_futbol;
                    identifier = 201
                },
                PrimaryDrawerItem().apply {
                    nameRes = R.string.prognosis;
                    iconicsIcon = faw_money_check;
                    identifier = 202
                },
                PrimaryDrawerItem().apply {
                    nameRes = R.string.totalizator;
                    iconicsIcon = faw_ruble_sign;
                    identifier = 203
                },
                PrimaryDrawerItem().apply {
                    nameRes = R.string.winners;
                    iconicsIcon = faw_trophy;
                    identifier = 204
                }
            )
        }

        //APP_ACTIVITY.mSlider.addStickyFooterItem(PrimaryDrawerItem().apply { nameText = "StickyFooter" })

        APP_ACTIVITY.mSlider.onDrawerItemClickListener = { _, drawerItem, _ ->
            val identifier = drawerItem.identifier.toInt()

            val fragment = when (identifier) {
                100 -> R.id.gamblersFragment
                /*101 -> R.id.registrationFragment
                102 -> R.id.loginFragment
                103 -> GamesFragment()
                104 -> PrognosisFragment()
                105 -> TotalizatorFragment()
                106 -> WinnersFragment()*/
                200 -> R.id.emailsFragment
                else -> R.id.gamblersFragment
            }

            APP_ACTIVITY.mNavController.navigate(fragment)

            false
        }
    }

    private fun setProfile(): ProfileDrawerItem {
        return ProfileDrawerItem().apply {
            //descriptionTextColor = ColorStateList.valueOf(Color.WHITE)
            //textColor = ColorStateList.valueOf(Color.WHITE)
            nameText = "MU"
            descriptionText = "Мягков Юрий"
            iconicsIcon = FontAwesome.Icon.faw_user
            //iconColor = ColorStateList.valueOf(Color.WHITE)
            //iconUrl = "empty"
            identifier = 100
        }
    }

    private fun createHeader() {
        // Create the AccountHeader
        mHeader = AccountHeaderView(APP_ACTIVITY).apply {
            attachToSliderView(APP_ACTIVITY.mSlider) // attach to the slider

            addProfiles(setProfile())

            setBackgroundColor(ContextCompat.getColor(context, R.color.application))


            /*onAccountHeaderListener = { _, _, _ ->
                // react to profile changes
                replaceFragment(ProfileFragment())
                false
            }*/

            //withSavedInstance(savedInstanceState)
        }
    }

    /*fun updateHeader() {
        mCurrentProfile.apply {
            nameText = USER.username;
            descriptionText = "${USER.family} ${USER.name}"
            iconUrl = USER.photoUrl
        }

        mHeader.updateProfile(mCurrentProfile)
    }*/

    /*private fun initImageLoader() {
        //initialize and create the image loader logic (for AccountHeader of MaterialDrawerSliderView)
        DrawerImageLoader.init(object : AbstractDrawerImageLoader() {
            override fun set(imageView: ImageView, uri: Uri, placeholder: Drawable, tag: String?) {
                imageView.loadImage(uri.toString())
                //Picasso.get().load(uri).placeholder(placeholder).into(imageView)
            }

            *//*override fun set(imageView: ImageView, uri: Uri, placeholder: Drawable, tag: String?) {
                super.set(imageView, uri, placeholder, tag)
            }

            override fun placeholder(ctx: Context): Drawable {
                return super.placeholder(ctx)
            }

            override fun placeholder(ctx: Context, tag: String?): Drawable {
                return super.placeholder(ctx, tag)
            }*//*
        })
    }*/
}