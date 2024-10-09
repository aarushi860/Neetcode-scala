package binarySearch.medium

import trie.TrieNode

object Leet1268SearchSuggestionsSystem {
  def suggestedProducts(products: Array[String], searchWord: String): List[List[String]] = {
    val root = new TrieNode
    products.foreach(word => insertToTrie(root, word))
    searchWord.indices.map { idx =>
      getSuggestions(searchWord.substring(0, idx + 1), root, 0)
    }.toList
  }

  private def insertToTrie(trieNode: TrieNode, word: String): Unit = {
    if (word.isEmpty) trieNode.isEnd = true
    else {
      val idx = word.head - 'a'
      if (trieNode.children(idx) == null) trieNode.children(idx) = new TrieNode
      insertToTrie(trieNode.children(idx), word.tail)
    }
  }

  private def getSuggestions(prefixWord: String, trieNode: TrieNode, idx: Int): List[String] = {
    if (idx == prefixWord.length) getResults(trieNode, List(), prefixWord)
    else {
      val i = prefixWord.charAt(idx) - 'a'
      if (trieNode.children(i) == null) List()
      else getSuggestions(prefixWord, trieNode.children(i), idx + 1)
    }
  }

  private def getResults(trieNode: TrieNode, result: List[String], formed: String): List[String] = {
    if (result.length == 3) result
    else {
      val updatedResult = if (trieNode.isEnd) result :+ formed else result
      ('a' to 'z').toList.foldLeft(updatedResult) {
        case (acc, ch) =>
          val idx = ch - 'a'
          if (trieNode.children(idx) != null) getResults(trieNode.children(idx), acc, formed + ch)
          else acc
      }
    }
  }


}
