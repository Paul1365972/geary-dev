package io.github.paul1365972.gearycore.systems.blazereap

import io.github.paul1365972.geary.ecs.Component
import io.github.paul1365972.gearycore.GearyCorePlugin
import io.github.paul1365972.story.StoryService
import io.github.paul1365972.story.key.CborDataKey
import kotlinx.serialization.Serializable
import org.bukkit.inventory.ItemStack

object BlazingExploderKey : CborDataKey<BlazingExploderComponent>(GearyCorePlugin, "blazing_exploder", BlazingExploderComponent.serializer()) {
    override fun copy(value: BlazingExploderComponent) = value.copy()
}

@Serializable
data class BlazingExploderComponent(
        var strength: Float = 1f
) : Component<BlazingExploderComponent>

var ItemStack.blazingExploderComponent: BlazingExploderComponent?
    get() = StoryService.itemStore.get(BlazingExploderKey, this)
    set(value) = StoryService.itemStore.set(BlazingExploderKey, this, value)
