package com.demo.so.post.entity

import com.demo.so.common.entity.BaseEntity
import com.vladmihalcea.hibernate.type.json.JsonType
import org.hibernate.annotations.Type
import org.hibernate.annotations.TypeDef
import javax.persistence.Column
import javax.persistence.Entity

@Entity
@TypeDef(name = "json", typeClass = JsonType::class)
class Post(
    title: String,
    content: String,
    tags: LinkedHashSet<String>
): BaseEntity() {
    val title: String = title

    val content: String = content

    @Type(type = "json")
    @Column(columnDefinition = "json")
    val tags: LinkedHashSet<String> = tags
}