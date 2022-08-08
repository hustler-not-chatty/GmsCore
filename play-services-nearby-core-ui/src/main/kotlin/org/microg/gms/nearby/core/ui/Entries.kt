package org.microg.gms.nearby.core.ui

import org.microg.gms.ui.base.CollapsingNavigationBaseFragment

class Entries {
    class ExposureNotificationsFragment :
        CollapsingNavigationBaseFragment(org.microg.gms.nearby.core.ui.ExposureNotificationsFragment())

    class ExposureNotificationsRpisFragment :
        CollapsingNavigationBaseFragment(org.microg.gms.nearby.core.ui.ExposureNotificationsRpisFragment())

    class ExposureNotificationsAppFragment :
        CollapsingNavigationBaseFragment(org.microg.gms.nearby.core.ui.ExposureNotificationsAppFragment())
}