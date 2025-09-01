package org.acad.data.local.settings

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId


/**
 * Created by Acad Bek on 8/1/2025
 */
class SettingsRealm : RealmObject {
    @PrimaryKey
    var id : ObjectId = ObjectId()
    var onboarded: Boolean = false
}