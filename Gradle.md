📦 KotlinプロジェクトにおけるGradle構成と役割

🔰 まず：GradleはKotlinのビルド・依存・実行を管理するビルドツール

KotlinでCLIアプリ・ライブラリ・Springアプリなどを作る際にも Gradle は欠かせません。

⸻

📁 プロジェクト構成ファイル一覧（例）

learning_gradle_with_kotlin/
├── build.gradle.kts             # Gradleのビルドルール（Kotlin DSL）
├── gradle.properties            # プロパティ定義
├── settings.gradle.kts          # サブプロジェクトやプロジェクト名の定義
├── gradle/
│   └── wrapper/
│       ├── gradle-wrapper.jar          # Gradle起動用JAR
│       └── gradle-wrapper.properties   # 使用するGradleのバージョンなど
├── gradlew                      # UNIX用Gradle起動スクリプト
├── gradlew.bat                  # Windows用Gradle起動スクリプト
└── src/
└── main/
└── kotlin/
└── App.kt           # Kotlinコード本体


⸻

🧩 各ファイルの解説

✅ build.gradle.kts（または build.gradle）

Gradleの ビルドスクリプト本体（Kotlin DSL）

plugins {
kotlin("jvm") version "1.9.10"
application
}

dependencies {
implementation(kotlin("stdlib"))
}

application {
mainClass.set("MainKt")
}

用途：
•	KotlinやJavaの依存関係指定
•	プラグイン読み込み（application, kotlin("jvm")など）
•	実行するメインクラスの指定
•	タスク定義（jar, run, test など）

⸻

✅ settings.gradle.kts

プロジェクトの 名前 や マルチプロジェクト構成を定義

rootProject.name = "learning_gradle_with_kotlin"


⸻

✅ gradle.properties

ビルドスクリプトやプラグインで使えるプロパティを定義
（例：JVMオプション、共通バージョン定義）

org.gradle.jvmargs=-Xmx1g
kotlin.code.style=official


⸻

⚙️ Gradle Wrapperとは？

「どの環境でも同じ Gradle バージョンを自動で使えるようにする仕組み」

✅ gradle-wrapper.properties

distributionUrl=https\://services.gradle.org/distributions/gradle-8.6-all.zip

ここで指定された Gradle バージョンが自動ダウンロード＆使用されます。

⸻

✅ gradle-wrapper.jar
•	上記 distributionUrl で指定された Gradle をダウンロード・実行する Java プログラム。
•	直接編集しません。gradle wrapper タスクで生成されます。

⸻

✅ gradlew / gradlew.bat
•	./gradlew（UNIX） or gradlew.bat（Windows）は、ローカル環境にGradleが入ってなくてもビルドできるようにするラッパースクリプト。
•	gradlew build などとすれば、指定されたバージョンが自動DL＆実行されます。

⸻

✅ まとめ：Kotlin + Gradle開発の最小構成

ファイル	役割
build.gradle.kts	ビルドルール本体
settings.gradle.kts	プロジェクト名・構成
gradle.properties	JVMオプションなど設定
gradle/wrapper/*.jar	Gradleをダウンロード・実行
gradlew / gradlew.bat	Gradleラッパー（ローカルに不要）


⸻

📘 公式ドキュメント
•	🌐 Gradle公式トップ
•	📚 Gradle Kotlin DSL公式ガイド
•	⚙️ Gradle Wrapper公式解説

⸻

💡 学習を進めるなら build.gradle.kts を触りながら、 ./gradlew tasks で何ができるか調べてみると理解が深まりますよ！

必要なら「自作Kotlinアプリに必要な最小Gradle構成例」も出せます！