package org.microg.gms.ui

import org.microg.gms.ui.base.CollapsingNavigationBaseFragment

class Entries {
    class SettingsFragment : CollapsingNavigationBaseFragment(org.microg.gms.ui.SettingsFragment())
    class SelfCheckFragment :
        CollapsingNavigationBaseFragment(org.microg.gms.ui.SelfCheckFragment())

    class DeviceRegistrationFragment :
        CollapsingNavigationBaseFragment(org.microg.gms.ui.DeviceRegistrationFragment())

    class PushNotificationFragment :
        CollapsingNavigationBaseFragment(org.microg.gms.ui.PushNotificationFragment())

    class PushNotificationAllAppsFragment :
        CollapsingNavigationBaseFragment(org.microg.gms.ui.PushNotificationAllAppsFragment())

    class PushNotificationAppFragment :
        CollapsingNavigationBaseFragment(org.microg.gms.ui.PushNotificationAppFragment())

    class PushNotificationAdvancedFragment :
        CollapsingNavigationBaseFragment(org.microg.gms.ui.PushNotificationAdvancedFragment())

    class SafetyNetFragment :
        CollapsingNavigationBaseFragment(org.microg.gms.ui.SafetyNetFragment())

    class SafetyNetAdvancedFragment :
        CollapsingNavigationBaseFragment(org.microg.gms.ui.SafetyNetAdvancedFragment())

    class AboutFragment : CollapsingNavigationBaseFragment(org.microg.gms.ui.AboutFragment())
}