package com.pedrorok.hypertube.client.renderer;

import com.pedrorok.hypertube.blocks.HyperEntranceBlock;
import com.pedrorok.hypertube.blocks.blockentities.HyperEntranceBlockEntity;
import com.pedrorok.hypertube.registry.ModPartialModels;
import com.zurrtum.create.client.catnip.render.CachedBuffers;
import com.zurrtum.create.client.catnip.render.SuperByteBuffer;
import com.zurrtum.create.client.content.kinetics.base.KineticBlockEntityRenderer;

/**
 * Create Fly 26.3 kinetic renderer for the hypertube entrance cogwheel.
 *
 * The 26.3 renderer API extracts a render state and submits it later;
 * the old renderSafe/MultiBufferSource hook no longer exists.
 */
public class EntranceBlockEntityRenderer extends KineticBlockEntityRenderer<
        HyperEntranceBlockEntity,
        KineticBlockEntityRenderer.KineticRenderState> {

    public EntranceBlockEntityRenderer(Context context) {
        super(context);
    }

    @Override
    protected SuperByteBuffer getRotatedModel(
            HyperEntranceBlockEntity blockEntity,
            KineticBlockEntityRenderer.KineticRenderState state) {
        var blockState = blockEntity.getBlockState();
        return CachedBuffers.partialFacingVertical(
                ModPartialModels.COGWHEEL_HOLE,
                blockState,
                blockState.getValue(HyperEntranceBlock.FACING)
        );
    }
}
