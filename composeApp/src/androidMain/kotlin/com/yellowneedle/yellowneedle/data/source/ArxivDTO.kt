package com.yellowneedle.yellowneedle.data.source
import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.*
import nl.adaptivity.xmlutil.serialization.XmlAttribute

@Serializable
@XmlSerialName("feed", "", "")
data class ArxivFeed(
    @XmlElement(true) val title: String? = null,
    @XmlElement(true) val id: String? = null,
    @XmlElement(true) val updated: String? = null,
    @XmlElement(true) val entry: List<ArxivEntry> = emptyList()
)

@Serializable
@XmlSerialName("entry", "", "")
data class ArxivEntry(
    @XmlElement(true) val id: String? = null,
    @XmlElement(true) val title: String? = null,
    @XmlElement(true) val summary: String? = null,
    @XmlElement(true) val published: String? = null,
    @XmlElement(true) val updated: String? = null,
    @XmlElement(true) val author: List<ArxivAuthor> = emptyList(),
    @XmlElement(true) val link: List<ArxivLink> = emptyList(),
    @XmlElement(true) val category: List<String> = emptyList()
)

@Serializable
@XmlSerialName("author", "", "")
data class ArxivAuthor(
    @XmlElement(true) val name: String? = null
)

@Serializable
@XmlSerialName("link", "", "")
data class ArxivLink(
    @XmlAttribute(true) val href: String? = null,
    @XmlAttribute(true) val rel: String? = null,
    @XmlAttribute(true) val type: String? = null
)

