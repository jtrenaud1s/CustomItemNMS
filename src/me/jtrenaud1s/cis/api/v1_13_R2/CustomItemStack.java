package me.jtrenaud1s.cis.api.v1_13_R2;

import com.google.common.collect.Lists;
import me.jtrenaud1s.cis.api.ACustomItemStack;
import me.jtrenaud1s.cis.api.CustomNBT;
import net.minecraft.server.v1_13_R2.*;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_13_R2.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Field;
import java.util.List;

public class CustomItemStack extends ACustomItemStack implements CustomNBT {
    private net.minecraft.server.v1_13_R2.ItemStack item;

    public CustomItemStack(){
        super();
        item = CraftItemStack.asNMSCopy(this);
    }

    public CustomItemStack(Material type) {
        super(type);
        item = CraftItemStack.asNMSCopy(this);
    }

    public CustomItemStack(Material type, int amount) {
        super(type, amount);
        item = CraftItemStack.asNMSCopy(this);
    }

    public CustomItemStack(ItemStack stack) throws IllegalArgumentException {
        super(stack);
        item = CraftItemStack.asNMSCopy(this);
    }

    public CustomItemStack(CustomItemStack stack) {
        super(stack);
        item = CraftItemStack.asNMSCopy(this);
    }

    @Override
    public void setMetadata(String metadata, Object value) {
        if(item.getTag() == null){
            item.setTag(new NBTTagCompound());
        }

        NBTBase base = null;

        if (value instanceof Boolean) {
            base = new NBTTagByte((byte)(((Boolean)value).booleanValue() ? 1 : 0));
        } else if (value instanceof Long) {
            base = new NBTTagLong((Long) value);
        } else if (value instanceof Integer) {
            base = new NBTTagInt((Integer) value);
        } else if (value instanceof Byte) {
            base = new NBTTagByte((Byte) value);
        } else if (value instanceof Double) {
            base = new NBTTagDouble((Double) value);
        } else if (value instanceof Float) {
            base = new NBTTagFloat((Float) value);
        } else if (value instanceof String) {
            base = new NBTTagString((String) value);
        } else if (value instanceof Short) {
            base = new NBTTagShort((Short) value);
        }

        if(base != null){
            item.getTag().set(metadata, base);
        }

        setItemMeta(CraftItemStack.getItemMeta(item));
    }

    @Override
    public boolean hasMetadata(String metadata) {
        return item.getTag() == null ? false : item.getTag().hasKey(metadata);
    }

    @Override
    public Object getMetadata(String metadata) {
        if(!hasMetadata( metadata))return null;
        return getObject(item.getTag().get(metadata));
    }

    @Override
    public Object getObject(Object tagO){
        NBTBase tag = (NBTBase) tagO;
        if(tag instanceof NBTTagEnd){
            return null;
        }else if(tag instanceof NBTTagLong){
            return ((NBTTagLong) tag).d();
        }else if(tag instanceof NBTTagByte){
            return ((NBTTagByte) tag).g();
        }else if(tag instanceof NBTTagShort){
            return ((NBTTagShort) tag).f();
        }else if(tag instanceof NBTTagInt){
            return ((NBTTagInt) tag).e();
        }else if(tag instanceof NBTTagFloat){
            return ((NBTTagFloat) tag).i();
        }else if(tag instanceof NBTTagDouble){
            return ((NBTTagDouble) tag).asDouble();
        }else if(tag instanceof NBTTagByteArray){
            return ((NBTTagByteArray) tag).c();
        }else if(tag instanceof NBTTagString){
            return ((NBTTagString) tag).b_();
        }else if(tag instanceof NBTTagList){
            List<NBTBase> list = null;
            try {
                Field field = tag.getClass().getDeclaredField("list");
                field.setAccessible(true);
                list = (List<NBTBase>)field.get(tag);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(list == null)return null;
            List<Object> toReturn = Lists.newArrayList();
            for(NBTBase base : list){
                toReturn.add(getObject(base));
            }
            return toReturn;
        }else if(tag instanceof NBTTagCompound){
            return tag;
        }else if(tag instanceof NBTTagIntArray){
            return ((NBTTagIntArray) tag).d();
        }
        return null;
    }
}
