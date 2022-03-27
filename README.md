# このプロジェクトについて

このプロジェクトは、[Server-Side Kotlin Meetup vol.2](https://server-side-kotlin-meetup.connpass.com/event/239291/)
で発表する事前準備として作成したものです。

Kotlin1.5で追加された `value class` に関して、各JSONパーサーライブラリが JSONシリアライズ / デシリアライズ をサポートしているかを調査しました。

## 調査結果

結果は以下です。

| ライブラリ名                | シリアライズ | デシリアライズ | メモ                                                                                               |
|-----------------------|--------|---------|--------------------------------------------------------------------------------------------------|
| kotlinx-serialization | 🟢     | 🟢      | JetBrains (Kotlinの開発元) から提供されているライブラリ                                                            |
| gson                  | 🟢     | 🟢      | ライブラリ自体がメンテナンスモードなので、今後の積極的な開発はなさそう?                                                             |
| jackson-module-kotlin | 🟢     | ❌       | [関連issue](https://github.com/FasterXML/jackson-module-kotlin/issues/199#issuecomment-1013810769) |
| moshi-kotlin          | ❌      | ❌       | [関連issue](https://github.com/square/moshi/issues/1170)                                           |

詳細はソースコードを参照ください。
https://github.com/baseballyama/kotlin-json-research/blob/9686900b173b820a528686ed68758ac4eb086dc0/src/main/kotlin/tokyo/baseballyama/kotlin_json_research/Main.kt#L37-L51