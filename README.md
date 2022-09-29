# stackoverflow-clone-server

## 실행
```
./gradlew bootRun
```

## 등록
```
# request
/post
{
    "title": "some",
    "content": "some",
    "tags": ["a", "b"]
}

#response
{
    "id": 2,
    "title": "title2",
    "content": "content2",
    "tags": ["a", "b", "c"],
    "createdAt": "2022-05-05 22:11:00"
}
```

## 전체 조회
```
# request
/posts

# response
[
    {
        "id": 1,
        "title": "title",
        "content": "content",
        "tags": ["a", "b", "c"],
        "createdAt": "2022-05-05 22:00:00"
    },
    {
        "id": 2,
        "title": "title2",
        "content": "content2",
        "tags": ["a", "b", "c"],
        "createdAt": "2022-05-05 22:11:00"
    }
]
```

## 단일 조회
```

# request
/posts/{id}

# response
{
    "id": 2,
    "title": "title2",
    "content": "content2",
    "tags": ["a", "b", "c"],
    "createdAt": "2022-05-05 22:11:00"
}
```

