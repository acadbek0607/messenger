package org.acad.data.store.settings

import io.realm.kotlin.types.ObjectId
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

/**
 * Created by Acad Bek on 2/17/2025
 */
data class SettingsRealm(
    @PrimaryKey
    val id: ObjectId = ObjectId.create(),
    val onboarded: Boolean = false
): RealmObject
