/*
 * SLD Editor - The Open Source Java SLD Editor
 *
 * Copyright (C) 2016, SCISYS UK Limited
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.sldeditor.extension.filesystem.file.esri;

import com.sldeditor.common.ToolSelectionInterface;
import com.sldeditor.extension.filesystem.ExtensionToolInterface;
import com.sldeditor.tool.legend.LegendTool;
import com.sldeditor.tool.savesld.SaveSLDTool;
import com.sldeditor.tool.scale.ScaleTool;

/**
 * The Class MXDTools registers any Esri MXD specific tools.
 *
 * @author Robert Ward (SCISYS)
 */
public class MXDTools implements ExtensionToolInterface {

    /**
     * Register extension specific tools.
     *
     * @param toolSelectionInterface the tool selection interface
     */
    @Override
    public void register(ToolSelectionInterface toolSelectionInterface)
    {
        if(toolSelectionInterface != null)
        {
            toolSelectionInterface.registerTool(MXDNode.class, new SaveSLDTool());
            toolSelectionInterface.registerTool(MXDLayerNode.class, new SaveSLDTool());
            toolSelectionInterface.registerTool(MXDNode.class, new LegendTool());
            toolSelectionInterface.registerTool(MXDLayerNode.class, new LegendTool());
            toolSelectionInterface.registerTool(MXDNode.class, new ScaleTool(toolSelectionInterface.getApplication()));
            toolSelectionInterface.registerTool(MXDLayerNode.class, new ScaleTool(toolSelectionInterface.getApplication()));
        }
    }
}