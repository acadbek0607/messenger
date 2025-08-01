package org.acad.data.local.settings

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import io.realm.kotlin.types.ObjectId


/**
 * Created by Acad Bek on 8/1/2025
 */
data class SettingsRealm(
    @PrimaryKey
    val id : ObjectId = ObjectId.create(),
    val onboarded: Boolean = false
) : RealmObject