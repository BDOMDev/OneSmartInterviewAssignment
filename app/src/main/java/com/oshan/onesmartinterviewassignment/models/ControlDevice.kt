package com.oshan.onesmartinterviewassignment.models

import android.os.Parcel
import android.os.Parcelable

data class ControlDevice(
    var name: String,
    var dashboard: String,
    var powerOn: Boolean,
    var connected: Boolean,
    var icon: Int,
    var specialFeature: Boolean
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte(),
        parcel.readInt(),
        parcel.readByte() != 0.toByte(),
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(dashboard)
        parcel.writeByte(if (powerOn) 1 else 0)
        parcel.writeByte(if (connected) 1 else 0)
        parcel.writeInt(icon)
        parcel.writeByte(if (specialFeature) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ControlDevice> {
        override fun createFromParcel(parcel: Parcel): ControlDevice {
            return ControlDevice(parcel)
        }

        override fun newArray(size: Int): Array<ControlDevice?> {
            return arrayOfNulls(size)
        }
    }
}