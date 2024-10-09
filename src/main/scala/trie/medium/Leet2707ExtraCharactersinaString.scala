//package trie.medium
//
//import trie.TrieNode
//
//object Leet2707ExtraCharactersinaString {
//  def minExtraChar(s: String, dictionary: Array[String]): Int = {
//    val trieNode = buildTrieFromDictionary(dictionary)
//    getMin(s, trieNode)
//  }
//
//  private def getMin(s: String, trieNode: TrieNode,rootNode:TrieNode): Int = {
//    if (s.isEmpty) 0
//    else {
//      val idx = s.head - 'a'
//      val childNode = trieNode.children(idx)
//      if (childNode == null) {
//        val newNode=rootNode
//        newNode.children()
//      } else getMin(s.tail, childNode)
//    }
//  }
//
//
//  private def buildTrieFromDictionary(dictionary: Array[String]) = {
//    val trieNode = new TrieNode
//    dictionary.foreach(word => insert(word, trieNode))
//    trieNode
//  }
//
//  private def insert(word: String, trieNode: TrieNode): Unit = {
//    if (word.nonEmpty) {
//      val ch = word.head
//      val childIdx = ch - 'a'
//      if (trieNode.children(childIdx) == null) trieNode.children(childIdx) = new TrieNode
//      insert(word.tail, trieNode.children(childIdx))
//    }
//  }
//}
