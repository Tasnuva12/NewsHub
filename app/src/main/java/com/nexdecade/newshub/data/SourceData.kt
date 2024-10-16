package com.nexdecade.newshub.data

import com.google.gson.annotations.SerializedName

data class SourceData(
    @SerializedName("status" ) var status : String? = null,
    @SerializedName("sources"      ) var sources     : List<SourceBean>? = null
)

data class SourceBean(
    @SerializedName("id") val id: String? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("description") val description: String? = null,
    @SerializedName("url") val url: String? = null,
    @SerializedName("category"    ) var category    : String? = null,
    @SerializedName("language"    ) var language    : String? = null,
    @SerializedName("country"     ) var country     : String? = null
)
