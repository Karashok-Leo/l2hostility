package karashokleo.l2hostility.compat.jade;

import net.minecraft.entity.LivingEntity;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
public class JadeCompat implements IWailaPlugin
{
    @Override
    public void registerClient(IWailaClientRegistration registration)
    {
        registration.registerEntityComponent(new TraitInfo(), LivingEntity.class);
    }
}
