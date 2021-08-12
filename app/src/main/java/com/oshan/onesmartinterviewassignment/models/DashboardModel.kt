package com.oshan.onesmartinterviewassignment.models

import android.os.Parcel
import android.os.Parcelable

data class DashboardModel(
    var name: String,
    var icon: Int,
    var controlDeviceList: ArrayList<ControlDevice> = ArrayList()
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readInt(),
        parcel.createTypedArrayList(ControlDevice)!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(icon)
        parcel.writeTypedList(controlDeviceList)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DashboardModel> {
        override fun createFromParcel(parcel: Parcel): DashboardModel {
            return DashboardModel(parcel)
        }

        override fun newArray(size: Int): Array<DashboardModel?> {
            return arrayOfNulls(size)
        }
    }
}