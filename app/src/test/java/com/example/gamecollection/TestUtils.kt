package com.example.gamecollection

class TestUtils {
    companion object{
        fun MockUpResponse():String{
            return """
                {
                    "id": 3328,
                    "slug": "the-witcher-3-wild-hunt",
                    "name": "The Witcher 3: Wild Hunt",
                    "name_original": "The Witcher 3: Wild Hunt",
                    "description": "<p>The third game in a series, it holds nothing back from the player. Open world adventures of the renowned monster slayer Geralt of Rivia are now even on a larger scale. Following the source material more accurately, this time Geralt is trying to find the child of the prophecy, Ciri while making a quick coin from various contracts on the side. Great attention to the world building above all creates an immersive story, where your decisions will shape the world around you.</p>\n<p>CD Project Red are infamous for the amount of work they put into their games, and it shows, because aside from classic third-person action RPG base game they provided 2 massive DLCs with unique questlines and 16 smaller DLCs, containing extra quests and items.</p>\n<p>Players praise the game for its atmosphere and a wide open world that finds the balance between fantasy elements and realistic and believable mechanics, and the game deserved numerous awards for every aspect of the game, from music to direction.</p>",
                    "metacritic": 92,
                    "metacritic_platforms": [
                        {
                            "metascore": 91,
                            "url": "https://www.metacritic.com/game/xbox-one/the-witcher-3-wild-hunt",
                            "platform": {
                                "platform": 1,
                                "name": "Xbox One",
                                "slug": "xbox-one"
                            }
                        },
                        {
                            "metascore": 93,
                            "url": "https://www.metacritic.com/game/pc/the-witcher-3-wild-hunt",
                            "platform": {
                                "platform": 4,
                                "name": "PC",
                                "slug": "pc"
                            }
                        },
                        {
                            "metascore": 92,
                            "url": "https://www.metacritic.com/game/playstation-4/the-witcher-3-wild-hunt",
                            "platform": {
                                "platform": 18,
                                "name": "PlayStation 4",
                                "slug": "playstation4"
                            }
                        }
                    ],
                    "released": "2015-05-18",
                    "tba": false,
                    "updated": "2023-06-12T14:22:08",
                    "background_image": "https://media.rawg.io/media/games/618/618c2031a07bbff6b4f611f10b6bcdbc.jpg",
                    "background_image_additional": "https://media.rawg.io/media/screenshots/3e4/3e4576a772b3df47bfc52b86e4cf7e03.jpg",
                    "website": "https://thewitcher.com/en/witcher3",
                    "rating": 4.66,
                    "rating_top": 5,
                    "ratings": [
                        {
                            "id": 5,
                            "title": "exceptional",
                            "count": 4770,
                            "percent": 77.44
                        },
                        {
                            "id": 4,
                            "title": "recommended",
                            "count": 984,
                            "percent": 15.97
                        },
                        {
                            "id": 3,
                            "title": "meh",
                            "count": 252,
                            "percent": 4.09
                        },
                        {
                            "id": 1,
                            "title": "skip",
                            "count": 154,
                            "percent": 2.5
                        }
                    ],
                    "reactions": {
                        "1": 53,
                        "2": 13,
                        "3": 50,
                        "4": 25,
                        "5": 14,
                        "6": 9,
                        "7": 15,
                        "10": 15,
                        "11": 17,
                        "12": 18,
                        "14": 1,
                        "15": 1,
                        "16": 3,
                        "21": 1
                    },
                    "added": 18649,
                    "added_by_status": {
                        "yet": 1066,
                        "owned": 10753,
                        "beaten": 4417,
                        "toplay": 733,
                        "dropped": 845,
                        "playing": 835
                    },
                    "playtime": 46,
                    "screenshots_count": 107,
                    "movies_count": 0,
                    "creators_count": 34,
                    "achievements_count": 684,
                    "parent_achievements_count": 49,
                    "reddit_url": "https://www.reddit.com/r/thewitcher3/",
                    "reddit_name": "r/thewitcher3",
                    "reddit_description": "A subreddit for veterans and new fans alike of The Witcher 3: Wild Hunt as well as for other Witcher games and the franchise in general. Everyone is welcome.",
                    "reddit_logo": "",
                    "reddit_count": 8621,
                    "twitch_count": 151,
                    "youtube_count": 1000000,
                    "reviews_text_count": 94,
                    "ratings_count": 6066,
                    "suggestions_count": 663,
                    "alternative_names": [],
                    "metacritic_url": "https://www.metacritic.com/game/playstation-4/the-witcher-3-wild-hunt",
                    "parents_count": 0,
                    "additions_count": 3,
                    "game_series_count": 8,
                    "user_game": null,
                    "reviews_count": 6160,
                    "saturated_color": "0f0f0f",
                    "dominant_color": "0f0f0f",
                    "parent_platforms": [
                        {
                            "platform": {
                                "id": 1,
                                "name": "PC",
                                "slug": "pc"
                            }
                        },
                        {
                            "platform": {
                                "id": 2,
                                "name": "PlayStation",
                                "slug": "playstation"
                            }
                        },
                        {
                            "platform": {
                                "id": 3,
                                "name": "Xbox",
                                "slug": "xbox"
                            }
                        },
                        {
                            "platform": {
                                "id": 7,
                                "name": "Nintendo",
                                "slug": "nintendo"
                            }
                        }
                    ],
                    "platforms": [
                        {
                            "platform": {
                                "id": 186,
                                "name": "Xbox Series S/X",
                                "slug": "xbox-series-x",
                                "image": null,
                                "year_end": null,
                                "year_start": 2020,
                                "games_count": 764,
                                "image_background": "https://media.rawg.io/media/games/5eb/5eb49eb2fa0738fdb5bacea557b1bc57.jpg"
                            },
                            "released_at": "2015-05-18",
                            "requirements": {}
                        },
                        {
                            "platform": {
                                "id": 18,
                                "name": "PlayStation 4",
                                "slug": "playstation4",
                                "image": null,
                                "year_end": null,
                                "year_start": null,
                                "games_count": 6638,
                                "image_background": "https://media.rawg.io/media/games/d82/d82990b9c67ba0d2d09d4e6fa88885a7.jpg"
                            },
                            "released_at": "2015-05-18",
                            "requirements": {}
                        },
                        {
                            "platform": {
                                "id": 7,
                                "name": "Nintendo Switch",
                                "slug": "nintendo-switch",
                                "image": null,
                                "year_end": null,
                                "year_start": null,
                                "games_count": 5241,
                                "image_background": "https://media.rawg.io/media/games/7fa/7fa0b586293c5861ee32490e953a4996.jpg"
                            },
                            "released_at": "2015-05-18",
                            "requirements": {}
                        },
                        {
                            "platform": {
                                "id": 4,
                                "name": "PC",
                                "slug": "pc",
                                "image": null,
                                "year_end": null,
                                "year_start": null,
                                "games_count": 513214,
                                "image_background": "https://media.rawg.io/media/games/021/021c4e21a1824d2526f925eff6324653.jpg"
                            },
                            "released_at": "2015-05-18",
                            "requirements": {}
                        },
                        {
                            "platform": {
                                "id": 1,
                                "name": "Xbox One",
                                "slug": "xbox-one",
                                "image": null,
                                "year_end": null,
                                "year_start": null,
                                "games_count": 5514,
                                "image_background": "https://media.rawg.io/media/games/960/960b601d9541cec776c5fa42a00bf6c4.jpg"
                            },
                            "released_at": "2015-05-18",
                            "requirements": {}
                        },
                        {
                            "platform": {
                                "id": 187,
                                "name": "PlayStation 5",
                                "slug": "playstation5",
                                "image": null,
                                "year_end": null,
                                "year_start": 2020,
                                "games_count": 884,
                                "image_background": "https://media.rawg.io/media/games/5ec/5ecac5cb026ec26a56efcc546364e348.jpg"
                            },
                            "released_at": "2015-05-18",
                            "requirements": {}
                        }
                    ],
                    "stores": [
                        {
                            "id": 354780,
                            "url": "",
                            "store": {
                                "id": 5,
                                "name": "GOG",
                                "slug": "gog",
                                "domain": "gog.com",
                                "games_count": 5203,
                                "image_background": "https://media.rawg.io/media/games/ee3/ee3e10193aafc3230ba1cae426967d10.jpg"
                            }
                        },
                        {
                            "id": 3565,
                            "url": "",
                            "store": {
                                "id": 3,
                                "name": "PlayStation Store",
                                "slug": "playstation-store",
                                "domain": "store.playstation.com",
                                "games_count": 7817,
                                "image_background": "https://media.rawg.io/media/games/bc0/bc06a29ceac58652b684deefe7d56099.jpg"
                            }
                        },
                        {
                            "id": 305376,
                            "url": "",
                            "store": {
                                "id": 1,
                                "name": "Steam",
                                "slug": "steam",
                                "domain": "store.steampowered.com",
                                "games_count": 76077,
                                "image_background": "https://media.rawg.io/media/games/f87/f87457e8347484033cb34cde6101d08d.jpg"
                            }
                        },
                        {
                            "id": 312313,
                            "url": "",
                            "store": {
                                "id": 2,
                                "name": "Xbox Store",
                                "slug": "xbox-store",
                                "domain": "microsoft.com",
                                "games_count": 4760,
                                "image_background": "https://media.rawg.io/media/games/f87/f87457e8347484033cb34cde6101d08d.jpg"
                            }
                        },
                        {
                            "id": 676022,
                            "url": "",
                            "store": {
                                "id": 6,
                                "name": "Nintendo Store",
                                "slug": "nintendo",
                                "domain": "nintendo.com",
                                "games_count": 8874,
                                "image_background": "https://media.rawg.io/media/games/c4b/c4b0cab189e73432de3a250d8cf1c84e.jpg"
                            }
                        }
                    ],
                    "developers": [
                        {
                            "id": 9023,
                            "name": "CD PROJEKT RED",
                            "slug": "cd-projekt-red",
                            "games_count": 23,
                            "image_background": "https://media.rawg.io/media/screenshots/276/2769fb828bd315104ba6791b05a75f9b.jpg"
                        }
                    ],
                    "genres": [
                        {
                            "id": 4,
                            "name": "Action",
                            "slug": "action",
                            "games_count": 172873,
                            "image_background": "https://media.rawg.io/media/games/736/73619bd336c894d6941d926bfd563946.jpg"
                        },
                        {
                            "id": 3,
                            "name": "Adventure",
                            "slug": "adventure",
                            "games_count": 132646,
                            "image_background": "https://media.rawg.io/media/games/942/9424d6bb763dc38d9378b488603c87fa.jpg"
                        },
                        {
                            "id": 5,
                            "name": "RPG",
                            "slug": "role-playing-games-rpg",
                            "games_count": 52540,
                            "image_background": "https://media.rawg.io/media/games/21c/21cc15d233117c6809ec86870559e105.jpg"
                        }
                    ],
                    "tags": [
                        {
                            "id": 31,
                            "name": "Singleplayer",
                            "slug": "singleplayer",
                            "language": "eng",
                            "games_count": 205885,
                            "image_background": "https://media.rawg.io/media/games/511/5118aff5091cb3efec399c808f8c598f.jpg"
                        },
                        {
                            "id": 40836,
                            "name": "Full controller support",
                            "slug": "full-controller-support",
                            "language": "eng",
                            "games_count": 14337,
                            "image_background": "https://media.rawg.io/media/games/f46/f466571d536f2e3ea9e815ad17177501.jpg"
                        },
                        {
                            "id": 13,
                            "name": "Atmospheric",
                            "slug": "atmospheric",
                            "language": "eng",
                            "games_count": 29484,
                            "image_background": "https://media.rawg.io/media/games/c4b/c4b0cab189e73432de3a250d8cf1c84e.jpg"
                        },
                        {
                            "id": 42,
                            "name": "Great Soundtrack",
                            "slug": "great-soundtrack",
                            "language": "eng",
                            "games_count": 3239,
                            "image_background": "https://media.rawg.io/media/games/bc0/bc06a29ceac58652b684deefe7d56099.jpg"
                        },
                        {
                            "id": 24,
                            "name": "RPG",
                            "slug": "rpg",
                            "language": "eng",
                            "games_count": 17284,
                            "image_background": "https://media.rawg.io/media/games/b7d/b7d3f1715fa8381a4e780173a197a615.jpg"
                        },
                        {
                            "id": 118,
                            "name": "Story Rich",
                            "slug": "story-rich",
                            "language": "eng",
                            "games_count": 18210,
                            "image_background": "https://media.rawg.io/media/games/960/960b601d9541cec776c5fa42a00bf6c4.jpg"
                        },
                        {
                            "id": 36,
                            "name": "Open World",
                            "slug": "open-world",
                            "language": "eng",
                            "games_count": 6273,
                            "image_background": "https://media.rawg.io/media/games/d69/d69810315bd7e226ea2d21f9156af629.jpg"
                        },
                        {
                            "id": 149,
                            "name": "Third Person",
                            "slug": "third-person",
                            "language": "eng",
                            "games_count": 9431,
                            "image_background": "https://media.rawg.io/media/games/d82/d82990b9c67ba0d2d09d4e6fa88885a7.jpg"
                        },
                        {
                            "id": 64,
                            "name": "Fantasy",
                            "slug": "fantasy",
                            "language": "eng",
                            "games_count": 24493,
                            "image_background": "https://media.rawg.io/media/games/aa3/aa36ba4b486a03ddfaef274fb4f5afd4.jpg"
                        },
                        {
                            "id": 37,
                            "name": "Sandbox",
                            "slug": "sandbox",
                            "language": "eng",
                            "games_count": 5904,
                            "image_background": "https://media.rawg.io/media/games/5bb/5bb55ccb8205aadbb6a144cf6d8963f1.jpg"
                        },
                        {
                            "id": 97,
                            "name": "Action RPG",
                            "slug": "action-rpg",
                            "language": "eng",
                            "games_count": 5721,
                            "image_background": "https://media.rawg.io/media/games/da1/da1b267764d77221f07a4386b6548e5a.jpg"
                        },
                        {
                            "id": 41,
                            "name": "Dark",
                            "slug": "dark",
                            "language": "eng",
                            "games_count": 14109,
                            "image_background": "https://media.rawg.io/media/games/be0/be01c3d7d8795a45615da139322ca080.jpg"
                        },
                        {
                            "id": 44,
                            "name": "Nudity",
                            "slug": "nudity",
                            "language": "eng",
                            "games_count": 4976,
                            "image_background": "https://media.rawg.io/media/games/67f/67f62d1f062a6164f57575e0604ee9f6.jpg"
                        },
                        {
                            "id": 336,
                            "name": "controller support",
                            "slug": "controller-support",
                            "language": "eng",
                            "games_count": 293,
                            "image_background": "https://media.rawg.io/media/games/942/9424d6bb763dc38d9378b488603c87fa.jpg"
                        },
                        {
                            "id": 145,
                            "name": "Choices Matter",
                            "slug": "choices-matter",
                            "language": "eng",
                            "games_count": 3582,
                            "image_background": "https://media.rawg.io/media/games/3cf/3cff89996570cf29a10eb9cd967dcf73.jpg"
                        },
                        {
                            "id": 192,
                            "name": "Mature",
                            "slug": "mature",
                            "language": "eng",
                            "games_count": 2193,
                            "image_background": "https://media.rawg.io/media/games/aa3/aa36ba4b486a03ddfaef274fb4f5afd4.jpg"
                        },
                        {
                            "id": 40,
                            "name": "Dark Fantasy",
                            "slug": "dark-fantasy",
                            "language": "eng",
                            "games_count": 3249,
                            "image_background": "https://media.rawg.io/media/games/a6c/a6ccd34125c594abf1a9c9821b9a715d.jpg"
                        },
                        {
                            "id": 66,
                            "name": "Medieval",
                            "slug": "medieval",
                            "language": "eng",
                            "games_count": 5369,
                            "image_background": "https://media.rawg.io/media/games/e40/e40cc9d1957b0a0ed7e389834457b524.jpg"
                        },
                        {
                            "id": 82,
                            "name": "Magic",
                            "slug": "magic",
                            "language": "eng",
                            "games_count": 8103,
                            "image_background": "https://media.rawg.io/media/games/ccf/ccf26f6e3d553a04f0033a8107a521b8.jpg"
                        },
                        {
                            "id": 218,
                            "name": "Multiple Endings",
                            "slug": "multiple-endings",
                            "language": "eng",
                            "games_count": 7088,
                            "image_background": "https://media.rawg.io/media/games/046/0464f4a36cd975a37c95b93b06058855.jpg"
                        }
                    ],
                    "publishers": [
                        {
                            "id": 7411,
                            "name": "CD PROJEKT RED",
                            "slug": "cd-projekt-red",
                            "games_count": 25,
                            "image_background": "https://media.rawg.io/media/games/e4c/e4cb54232b241ecf152cc2f96ba2d379.jpg"
                        }
                    ],
                    "esrb_rating": {
                        "id": 4,
                        "name": "Mature",
                        "slug": "mature"
                    },
                    "clip": null,
                    "description_raw": "The third game in a series, it holds nothing back from the player. Open world adventures of the renowned monster slayer Geralt of Rivia are now even on a larger scale. Following the source material more accurately, this time Geralt is trying to find the child of the prophecy, Ciri while making a quick coin from various contracts on the side. Great attention to the world building above all creates an immersive story, where your decisions will shape the world around you.\n\nCD Project Red are infamous for the amount of work they put into their games, and it shows, because aside from classic third-person action RPG base game they provided 2 massive DLCs with unique questlines and 16 smaller DLCs, containing extra quests and items.\n\nPlayers praise the game for its atmosphere and a wide open world that finds the balance between fantasy elements and realistic and believable mechanics, and the game deserved numerous awards for every aspect of the game, from music to direction."
                }
            """.trimIndent()
        }
    }
}