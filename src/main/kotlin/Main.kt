package org.example

/**
 * Kotlinの「it」の使い方サンプル
 * 
 * このファイルはKotlinの「it」キーワードの使い方を説明するサンプルコードです。
 * 「it」はラムダ式で単一の引数を参照するための暗黙的な名前です。
 */
fun main() {
    println("===== Kotlinの「it」の使い方サンプル =====")

    // 基本的な例: リストのフィルタリング
    basicExample()

    // コレクション操作での「it」の使用
    collectionOperations()

    // スコープ関数での「it」の使用
    scopeFunctions()

    // 複数のパラメータがある場合
    multipleParameters()

    // 「it」を使わない場合（明示的な引数名の使用）
    withoutIt()
}

/**
 * 基本的な例: 「it」の基本的な使い方
 */
fun basicExample() {
    println("\n----- 基本的な例 -----")

    // 単一引数のラムダ式では、引数は自動的に「it」という名前で参照できます
    val numbers = listOf(1, 2, 3, 4, 5)

    // 偶数のみをフィルタリング
    val evenNumbers = numbers.filter { it % 2 == 0 }
    println("偶数: $evenNumbers")  // 出力: 偶数: [2, 4]

    // 各要素を2倍にする
    val doubledNumbers = numbers.map { it * 2 }
    println("2倍の数: $doubledNumbers")  // 出力: 2倍の数: [2, 4, 6, 8, 10]
}

/**
 * コレクション操作での「it」の使用例
 */
fun collectionOperations() {
    println("\n----- コレクション操作での「it」の使用 -----")

    val fruits = listOf("りんご", "バナナ", "オレンジ", "ぶどう", "いちご")

    // filter: 条件に一致する要素のみを抽出
    val shortFruits = fruits.filter { it.length <= 3 }
    println("3文字以下の果物: $shortFruits")

    // map: 各要素を変換
    val fruitLengths = fruits.map { "${it}は${it.length}文字です" }
    println("果物の長さ: $fruitLengths")

    // forEach: 各要素に対して処理を実行
    println("果物リスト:")
    fruits.forEach { println("- $it") }

    // find: 条件に一致する最初の要素を検索
    val firstLongFruit = fruits.find { it.length > 3 }
    println("最初の4文字以上の果物: $firstLongFruit")

    // any: 条件に一致する要素が1つでもあるかチェック
    val hasLongFruit = fruits.any { it.length > 5 }
    println("5文字以上の果物がありますか？: $hasLongFruit")
}

/**
 * スコープ関数での「it」の使用例
 */
fun scopeFunctions() {
    println("\n----- スコープ関数での「it」の使用 -----")

    data class Person(var name: String, var age: Int)

    // let: オブジェクトをitとして参照し、最後の式を戻り値とする
    val person = Person("田中", 30)
    val greeting = person.let {
        println("Person: ${it.name}, ${it.age}歳")
        "こんにちは、${it.name}さん！"  // 戻り値
    }
    println(greeting)

    // also: オブジェクトをitとして参照し、オブジェクト自体を戻り値とする
    val modifiedPerson = person.also {
        it.age += 1
        println("${it.name}の年齢を${it.age}歳に更新しました")
    }
    println("更新後: ${modifiedPerson.name}, ${modifiedPerson.age}歳")
}

/**
 * 複数のパラメータがある場合の例
 * （この場合は「it」は使えないので、明示的に引数名を指定する必要があります）
 */
fun multipleParameters() {
    println("\n----- 複数のパラメータがある場合 -----")

    val numbers = listOf(1, 2, 3, 4, 5)

    // foldは2つのパラメータを取るので、itは使えない
    val sum = numbers.fold(0) { acc, num -> acc + num }
    println("合計: $sum")

    // zipWithNextも2つのパラメータを取る
    val pairs = numbers.zipWithNext { a, b -> "$a→$b" }
    println("隣接ペア: $pairs")
}

/**
 * 「it」を使わない場合（明示的な引数名の使用）
 */
fun withoutIt() {
    println("\n----- 「it」を使わない場合 -----")

    val numbers = listOf(1, 2, 3, 4, 5)

    // 明示的に引数名を指定することもできます
    val evenNumbers = numbers.filter { number -> number % 2 == 0 }
    println("偶数（明示的な引数名）: $evenNumbers")

    // 長いラムダや複雑なロジックでは、明示的な引数名を使うと読みやすくなります
    val processedNumbers = numbers.map { number -> 
        val doubled = number * 2
        val description = if (doubled > 5) "大きい" else "小さい"
        "$number の2倍は $doubled ($description)"
    }
    println("処理結果: $processedNumbers")
}
