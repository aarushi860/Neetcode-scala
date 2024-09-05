package trie.medium

import trie.TrieNode

object Leet2707ExtraCharactersinaString {
  def minExtraChar(s: String, dictionary: Array[String]): Int = {
    val trieNode = new TrieNode
    addWordsToTrie(dictionary, trieNode)
    ???
  }

  private def search(idx: Int, trieNode: TrieNode) = {

  }

  private def addWordsToTrie(dictionary: Array[String], trieNode: TrieNode) = {
    dictionary.foreach(word => insertWord(trieNode, word))
  }

  private def insertWord(trieNode: TrieNode, word: String) = {
    var node = trieNode
    for (character <- word) {
      val idx = character - 'a'
      if (node.children(idx) == null) node.children(idx) = new TrieNode
      node = node.children(idx)
    }
    node.isEnd = true
  }
}
