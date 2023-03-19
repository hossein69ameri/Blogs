package com.example.smilinno_ameri.model


import com.google.gson.annotations.SerializedName

data class ResponseDetail(
    @SerializedName("author")
    val author: String?, // David Farrel
    @SerializedName("body")
    val body: String?, // <p>Unfurl the faded summer bunting. Crank the thermostat up half a notch. Bask in the yellowy glow from that rectangular screen in the corner of the room. The most divisive, brutal, mindbogglingly corrupt sporting event of the modern age is now upon us. It is time, finally, to Discover Amazing, as the Qatar 2022 Fifa men’s World Cup repeatedly urges the passing traffic on the endless hoardings and fences ringing this city of light and sheer surfaces.</p><p>On Sunday evening the footballers of Ecuador and Qatar will walk out for the opening game at the Al Bayt stadium. Over the next 29 days Qatar’s eight box-fresh arenas, gleaming glass and steel monuments to the men who died in their construction, will live out their own brief sepulchral lifespans before being dismantled for parts or converted into shopping malls.</p><p>England play Iran on Monday in the mid-afternoon heat. Wales kick off against the USA in the evening. Twelve years, £220bn, and thousands of unexplained deaths in the making, it seems we really are going to play football after all. Welcome to the damned World Cup.</p>
    @SerializedName("comments")
    val comments: List<Comment?>?,
    @SerializedName("date")
    val date: String?, // 2022-11-22T14:24:18
    @SerializedName("id")
    val id: Int?, // 3
    @SerializedName("path")
    val path: String?, // http://94.101.179.76:4005/blog3.jpg
    @SerializedName("title")
    val title: String? // The damned World Cup kicks off and Qatar is not in any mood to apologise
) {
    data class Comment(
        @SerializedName("avatar")
        val avatar: String?, // http://94.101.179.76:4005/avatar2.jpg
        @SerializedName("body")
        val body: String?, // World cup is not too important
        @SerializedName("createdOn")
        val createdOn: String?, // 2022-11-22T14:54:18
        @SerializedName("id")
        val id: Int?, // 0
        @SerializedName("username")
        val username: String? // Falcone
    )
}