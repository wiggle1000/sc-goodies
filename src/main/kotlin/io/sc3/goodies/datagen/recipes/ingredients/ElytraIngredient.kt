package io.sc3.goodies.datagen.recipes.ingredients

import net.fabricmc.fabric.api.entity.event.v1.FabricElytraItem
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import io.sc3.goodies.elytra.BaseElytraItem
import io.sc3.goodies.elytra.DyedElytraItem
import io.sc3.goodies.elytra.SpecialElytraType
import io.sc3.library.recipe.BaseIngredient

class ElytraIngredient : BaseIngredient() {
  private val matched by lazy {
    (
      listOf(Items.ELYTRA) +
      DyedElytraItem.dyedElytraItems.values +
      SpecialElytraType.values().map { it.item }
    ).map { ItemStack(it) }.toTypedArray()
  }

  override fun getMatchingStacks() = matched

  override fun test(stack: ItemStack?): Boolean {
    if (stack == null || stack.isEmpty) return false
    return stack.isOf(Items.ELYTRA) || stack.item is BaseElytraItem || stack.item is FabricElytraItem
  }

  override fun isEmpty() = false
}