package com.yellowneedle.yellowneedle.data.dto

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "feed", strict = false)
data class ArxivFeed(
    @field:Element(name = "title", required = false)
    var title: String? = null,

    @field:Element(name = "id", required = false)
    var id: String? = null,

    @field:Element(name = "updated", required = false)
    var updated: String? = null,

    @field:ElementList(inline = true, entry = "entry", required = false)
    var entries: MutableList<ArxivEntry> = mutableListOf()
)

@Root(name = "entry", strict = false)
data class ArxivEntry(
    @field:Element(name = "id", required = false) var id: String? = null,
    @field:Element(name = "title", required = false) var title: String? = null,
    @field:Element(name = "summary", required = false) var summary: String? = null,
    @field:Element(name = "published", required = false) var published: String? = null,
    @field:Element(name = "updated", required = false) var updated: String? = null,

    @field:ElementList(inline = true, entry = "author", required = false)
    var authors: MutableList<ArxivAuthor> = mutableListOf(),

    @field:ElementList(inline = true, entry = "link", required = false)
    var links: MutableList<ArxivLink> = mutableListOf(),

    @field:ElementList(inline = true, entry = "category", required = false)
    var categories: MutableList<String> = mutableListOf()
)

@Root(name = "author", strict = false)
data class ArxivAuthor(
    @field:Element(name = "name", required = false)
    var name: String? = null
)

@Root(name = "link", strict = false)
data class ArxivLink(
    @field:Element(name = "href", required = false) var href: String? = null,
    @field:Element(name = "rel", required = false) var rel: String? = null,
    @field:Element(name = "type", required = false) var type: String? = null
)

